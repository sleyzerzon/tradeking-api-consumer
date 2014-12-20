/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.MarketOperations;
import com.miserablemind.api.consumer.tradeking.api.domain.market.*;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.*;
import com.miserablemind.api.consumer.tradeking.connect.TradeKingServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.social.ApiException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MarketTemplate extends BaseTemplate implements MarketOperations {

  private static final String URL_QUOTES = "market/ext/quotes.json";
  private static final String URL_SEARCH_OPTIONS = "market/options/search.json";
  private static final String URL_SEARCH_OPTION_STRIKES = "market/options/strikes.json";
  private static final String URL_SEARCH_OPTION_DATES = "market/options/expirations.json";
  private static final String URL_SEARCH_NEWS = "market/news/search.json";
  private static final String URL_GET_NEWS = "market/news/%s.json";
  private static final String URL_MARKET_STATUS = "market/clock.json";
  private static final String URL_TOP_LIST = "market/toplists/%s.json";
  private static final String URL_DATA_POINTS = "market/timesales.json";

  MarketTemplate(RestTemplate restTemplate) {
    super(restTemplate);
  }

  @Override
  public StockQuote getQuoteForStock(String ticker) {
    StockQuote[] quotes = this.getQuoteForStocks(new String[]{ticker});
    return quotes[0];
  }

  @Override
  public StockQuote[] getQuoteForStocks(String[] tickers) {

    String tickersParamString = this.buildURIFromParamList(tickers);

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set("symbols", tickersParamString);

    URI url = this.buildUri(URL_QUOTES, parameters);
    ResponseEntity<TKStockQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKStockQuoteResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getQuotes();
  }

  @Override
  public OptionQuote getQuoteForOption(String ticker, Calendar expirationDate, OptionQuote.OptionType type, double strikePrice) throws OptionQuoteNotFoundException {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");

    String optionType = (type == OptionQuote.OptionType.CALL) ? "C" : "P";
    String timeString = dateFormat.format(expirationDate.getTime());
    String paddedPrice = String.format("%08d", (int) (strikePrice * 1000));

    String optionSymbol = ticker + timeString + optionType + paddedPrice;

    String tickersParamString = this.buildURIFromParamList(new String[]{optionSymbol});

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set("symbols", tickersParamString);

    try {
      URI url = this.buildUri(URL_QUOTES, parameters);
      ResponseEntity<TKOptionQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKOptionQuoteResponse.class);
      if (null != response.getBody().getError())
        throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());
      return response.getBody().getQuotes()[0];
    } catch (Exception e) {
      throw new OptionQuoteNotFoundException();
    }

  }

  @Override
  public OptionQuote[] searchOptions(String ticker, Double minStrikePrice, Double maxStrikePrice, OptionQuote.OptionType type, Calendar startDate, Calendar endDate) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    String queryString = "put_call-eq:" + type;

    //Strike Prices
    if (null != minStrikePrice) queryString += " AND strikeprice-gte:" + minStrikePrice;
    if (null != maxStrikePrice) queryString += " AND strikeprice-lte:" + maxStrikePrice;

    //Dates
    if (null != startDate) queryString += " AND xdate-gte:" + dateFormat.format(startDate.getTime());
    if (null != endDate) queryString += " AND xdate-lte:" + dateFormat.format(endDate.getTime());

    parameters.set("symbol", ticker);
    parameters.set("query", queryString);

    URI url = this.buildUri(URL_SEARCH_OPTIONS, parameters);
    ResponseEntity<TKOptionQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKOptionQuoteResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getQuotes();

  }

  @Override
  public Double[] getStrikePrices(String ticker) {
    URI url = this.buildUri(URL_SEARCH_OPTION_STRIKES, "symbol", ticker);
    ResponseEntity<TKOptionStrikesResponse> response = this.getRestTemplate().getForEntity(url, TKOptionStrikesResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getPrices();

  }

  @Override
  public Calendar[] getOptionExpirationDates(String ticker) {
    URI url = this.buildUri(URL_SEARCH_OPTION_DATES, "symbol", ticker);
    ResponseEntity<TKOptionExpirationsResponse> response = this.getRestTemplate().getForEntity(url, TKOptionExpirationsResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getDates();

  }

  @Override
  public NewsArticle[] getNewsList(String ticker, int limit) {
    return this.getNewsList(new String[]{ticker}, limit, null, null, null);
  }

  @Override
  public NewsArticle[] getNewsList(String[] keywords, int limit) {
    return this.getNewsList(null, limit, keywords, null, null);
  }


  protected NewsArticle[] getNewsList(String[] tickers, Integer limit, String[] keywords, Calendar startDate, Calendar endDate) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();


    if (null != tickers) parameters.set("symbols", this.buildURIFromParamList(tickers));
    if (null != limit) parameters.set("maxhits", String.valueOf(limit));

    if (null != keywords) parameters.set("keywords", this.buildURIFromParamList(keywords));

    //todo: dates do not work, figure out the format, TK does not like anything
    if (null != startDate) {
      parameters.set("startdate", dateFormat.format(startDate.getTime()));

      if (null != endDate) {
        parameters.set("enddate", dateFormat.format(endDate.getTime()));
      } else {
        parameters.set("enddate", dateFormat.format(new Date()));
      }

    }

    URI url = this.buildUri(URL_SEARCH_NEWS, parameters);
    ResponseEntity<TKNewsArticlesSearchResponse> response = this.getRestTemplate().getForEntity(url, TKNewsArticlesSearchResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getArticles();

  }

  @Override
  public NewsArticle getNewsById(String newsId) {
    URI url = this.buildUri(String.format(URL_GET_NEWS, newsId));

    ResponseEntity<TKNewsArticleGetResponse> response = this.getRestTemplate().getForEntity(url, TKNewsArticleGetResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getArticle();

  }

  @Override
  public MarketStatus getMarketStatus() {
    URI url = this.buildUri(URL_MARKET_STATUS);

    ResponseEntity<TKMarketStatusResponse> response = this.getRestTemplate().getForEntity(url, TKMarketStatusResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getMarketStatus();

  }

  @Override
  public TopListEntry[] getTopList(TopListEntry.ListType listType) {
    URI url = this.buildUri(String.format(URL_TOP_LIST, listType));
    ResponseEntity<TKTopListResponse> response = this.getRestTemplate().getForEntity(url, TKTopListResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getTopList();

  }

  //intraday
  @Override
  public TimeSalesQuote[] getDataPoints(String ticker, int pageNumber, int perPage) {
    int offset = (pageNumber - 1) * perPage + 1;
    return this.getDataPoints(ticker, TimeSalesQuote.Interval.TICK, perPage, offset, null, null);
  }

  //multiday
  @Override
  public TimeSalesQuote[] getDataPoints(String ticker, Calendar startDate, Calendar endDate, TimeSalesQuote.Interval interval) {
    return this.getDataPoints(ticker, interval, null, null, startDate, endDate);
  }


  // there is no universal usage of this one, see overloaded methods
  protected TimeSalesQuote[] getDataPoints(String ticker, TimeSalesQuote.Interval interval, Integer countPerPage,
                                           Integer offset, Calendar startDate, Calendar endDate) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

    parameters.set("symbols", ticker);

    if (null != interval) {
      parameters.set("interval", String.valueOf(interval));
      if (interval == TimeSalesQuote.Interval.TICK) {

        if (null != countPerPage) {
          parameters.set("rpp", String.valueOf(countPerPage));
          if (null != offset) parameters.set("index", String.valueOf(offset));
        }
      }
    }

    if (null != startDate) parameters.set("startdate", dateFormat.format(startDate.getTime()));
    if (null != endDate) parameters.set("enddate", dateFormat.format(endDate.getTime()));

    URI url = this.buildUri(URL_DATA_POINTS, parameters);

    ResponseEntity<TKTimeSalesQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKTimeSalesQuoteResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getQuotes();

  }

}
