package com.miserablemind.twtbeat.domain.service.traderking.api.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.history.TKTransactionHistoryEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.holdings.AccountHoldings;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.*;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.TKUser;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities.*;
import com.miserablemind.twtbeat.domain.service.traderking.connect.TraderKingServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.ApiException;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

public class TraderKingTemplate extends AbstractOAuth1ApiBinding implements TraderKingOperations {

  private static final String API_URL_BASE = "https://api.tradeking.com/v1/";

  private static final String API_URL_PROFILE = "member/profile.json";
  private static final String API_URL_ACCOUNTS = "accounts.json";
  private static final String API_URL_QUOTES = "market/ext/quotes.json";
  private static final String API_URL_SEARCH_OPTIONS = "market/options/search.json";
  private static final String API_URL_SEARCH_OPTION_STRIKES = "market/options/strikes.json";
  private static final String API_URL_ACCOUNT_BALANCES = "accounts/%s/balances.json";
  private static final String API_URL_ACCOUNT_HOLDINGS = "accounts/%s/holdings.json";
  private static final String API_URL_ACCOUNT_HISTORY = "accounts/%s/history.json";
  private static final String API_URL_SEARCH_OPTION_DATES = "market/options/expirations.json";
  private static final String API_URL_SEARCH_NEWS = "market/news/search.json";
  private static final String API_URL_GET_NEWS = "market/news/%s.json";
  private static final String API_URL_MARKET_STATUS = "market/clock.json";
  private static final String API_URL_TOP_LIST = "market/toplists/%s.json";
  private static final String API_URL_DATA_POINTS = "market/timesales.json";

  public TraderKingTemplate(String consumerKey, String consumerSecret, String accessToken, String secret) {
    super(consumerKey, consumerSecret, accessToken, secret);
  }

  @Override
  public TKUser getCurrentUser() {
    URI url = this.buildUri(API_URL_PROFILE);
    ResponseEntity<TKUserResponse> response = this.getRestTemplate().getForEntity(url, TKUserResponse.class);
    if (response.getBody().getError().equals("success"))
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getUserData();

  }

  @Override
  public AccountsSummary[] getAccount() {

    URI url = this.buildUri(API_URL_ACCOUNTS);
    ResponseEntity<TKAllAccountsResponse> response = this.getRestTemplate().getForEntity(url, TKAllAccountsResponse.class);

    if (response.getBody().getError() != null)
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getAccounts();
  }

  @Override
  public AccountBalance getAccountBalance(String accountId) {
    URI url = this.buildUri(String.format(API_URL_ACCOUNT_BALANCES, accountId));
    ResponseEntity<TKAccountBalanceResponse> response = this.getRestTemplate().getForEntity(url, TKAccountBalanceResponse.class);
    if (!response.getBody().getError().equals("Success"))
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getAccountBalance();
  }

  @Override
  public AccountHoldings getAccountHoldings(String accountId) {
    URI url = this.buildUri(String.format(API_URL_ACCOUNT_HOLDINGS, accountId));
    ResponseEntity<TKAccountHoldingsResponse> response = this.getRestTemplate().getForEntity(url, TKAccountHoldingsResponse.class);
    if (!response.getBody().getError().equals("Success"))
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getAccountHoldings();
  }

  @Override
  public TKTransactionHistoryEntry[] getAllHistory(String accountId) {

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set("range", TKTransactionHistoryEntry.TRANSACTION_RANGE_ALL);
    parameters.set("transactions", TKTransactionHistoryEntry.TRANSACTION_TYPE_ALL.toLowerCase());

    URI url = this.buildUri(String.format(API_URL_ACCOUNT_HISTORY, accountId), parameters);
    ResponseEntity<TKHistoryResponse> response = this.getRestTemplate().getForEntity(url, TKHistoryResponse.class);
    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getTransactionHistory();
  }


  @Override
  public void updateStatus() {
    //void
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

    URI url = this.buildUri(API_URL_QUOTES, parameters);
    ResponseEntity<TKStockQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKStockQuoteResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

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
      URI url = this.buildUri(API_URL_QUOTES, parameters);
      ResponseEntity<TKOptionQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKOptionQuoteResponse.class);
      if (null != response.getBody().getError())
        throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
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

    URI url = this.buildUri(API_URL_SEARCH_OPTIONS, parameters);
    ResponseEntity<TKOptionQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKOptionQuoteResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getQuotes();

  }

  @Override
  public Double[] getStrikePrices(String ticker) {
    URI url = this.buildUri(API_URL_SEARCH_OPTION_STRIKES, "symbol", ticker);
    ResponseEntity<TKOptionStrikesResponse> response = this.getRestTemplate().getForEntity(url, TKOptionStrikesResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getPrices();

  }

  @Override
  public Calendar[] getOptionExpirationDates(String ticker) {
    URI url = this.buildUri(API_URL_SEARCH_OPTION_DATES, "symbol", ticker);
    ResponseEntity<TKOptionExpirationsResponse> response = this.getRestTemplate().getForEntity(url, TKOptionExpirationsResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getDates();

  }

  @Override
  public NewsArticle[] getLatestCompanyNews(String ticker, int limit) {
    return this.getNewsList(new String[]{ticker}, limit, null, null, null);
  }

  @Override
  public NewsArticle[] getNewsByKeywords(String[] keywords, int limit) {
    return this.getNewsList(null, limit, keywords, null, null);
  }


  protected NewsArticle[] getNewsList(String[] tickers, Integer limit, String[] keywords, Calendar startDate, Calendar endDate) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();


    if (null != tickers) parameters.set("symbols", this.buildURIFromParamList(tickers));
    if (null != limit) parameters.set("maxhits", String.valueOf(limit));

    if (null != keywords) parameters.set("keywords", this.buildURIFromParamList(keywords));

    //todo: dates do not work, figure out the format
    if (null != startDate) {
      parameters.set("startdate", dateFormat.format(startDate.getTime()));

      if (null != endDate) {
        parameters.set("enddate", dateFormat.format(endDate.getTime()));
      } else {
        parameters.set("enddate", dateFormat.format(new Date()));
      }

    }

    URI url = this.buildUri(API_URL_SEARCH_NEWS, parameters);
    ResponseEntity<TKNewsArticlesSearchResponse> response = this.getRestTemplate().getForEntity(url, TKNewsArticlesSearchResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getArticles();

  }

  @Override
  public NewsArticle getNewsById(String newsId) {
    URI url = this.buildUri(String.format(API_URL_GET_NEWS, newsId));

    ResponseEntity<TKNewsArticleGetResponse> response = this.getRestTemplate().getForEntity(url, TKNewsArticleGetResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getArticle();

  }

  @Override
  public MarketStatus getMarketStatus() {
    URI url = this.buildUri(API_URL_MARKET_STATUS);

    ResponseEntity<TKMarketStatusResponse> response = this.getRestTemplate().getForEntity(url, TKMarketStatusResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getMarketStatus();

  }

  @Override
  public TopListEntry[] getTopList(TopListEntry.ListType listType) {
    URI url = this.buildUri(String.format(API_URL_TOP_LIST, listType));
    ResponseEntity<TKTopListResponse> response = this.getRestTemplate().getForEntity(url, TKTopListResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getTopList();

  }

  @Override
  public TimeSalesQuote[] getDataPoints(String ticker, TimeSalesQuote.Interval interval, Integer countPerPage, Integer offset, Calendar startDate, Calendar endDate, Calendar startTime) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

    parameters.set("symbols", ticker);

    if (null != interval) {
      parameters.set("interval", String.valueOf(interval));
      if (interval == TimeSalesQuote.Interval.TICKER) {

        if (null != countPerPage) {
          parameters.set("rpp", String.valueOf(countPerPage));
          if (null != offset) parameters.set("index", String.valueOf(countPerPage));
        }
      }
    }
    parameters.set("startdate", dateFormat.format(startDate.getTime()));
    parameters.set("enddate", dateFormat.format(endDate.getTime()));

    URI url = this.buildUri(API_URL_DATA_POINTS, parameters);

    ResponseEntity<TKTimeSalesQuoteResponse> response = this.getRestTemplate().getForEntity(url, TKTimeSalesQuoteResponse.class);

    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    //  return response.getBody().getQuotes();
    return null;

  }

  protected String buildURIFromParamList(String[] parametersList) {
    StringBuilder builder = new StringBuilder();
    List<String> parameters = new ArrayList<String>(Arrays.asList(parametersList));
    builder.append(parameters.remove(0));
    for (String parameter : parameters) {
      builder.append(",");
      builder.append(parameter);
    }
    return builder.toString();
  }

  protected URI buildUri(String path) {
    return this.buildUri(path, EMPTY_PARAMETERS);
  }

  protected URI buildUri(String path, String parameterName, String parameterValue) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set(parameterName, parameterValue);
    return this.buildUri(path, parameters);
  }

  protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
    return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
  }

  private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

  @Override
  protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
    MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
    mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
    mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    mapper.registerModule(new TraderKingModule());

    converter.setObjectMapper(mapper);
    return converter;
  }

}
