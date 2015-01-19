package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.market.*;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.ApiException;

import java.util.Calendar;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class MarketTemplateTest extends BaseTemplateTest {

    @Test
    public void getMarketStatus() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/clock.json"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/market_status"), MediaType.APPLICATION_JSON));

        MarketStatus status = tradeKing.getMarketOperations().getMarketStatus();
        mockServer.verify();

        assertEquals("MarketStatus Dates are not equal", status.getDate(), mockData.marketStatus.getDate());
        assertEquals("MarketStatus objects are not equal", status, mockData.marketStatus);
    }

    @Test(expected = ApiException.class)
    public void getMarketStatus_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/clock.json"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getMarketStatus();
        mockServer.verify();
    }

    @Test
    public void getDataPoints_Tick() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/timesales.json?symbols=TCKR&interval=tick&rpp=20&index=21"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/time_sales_quotes"), MediaType.APPLICATION_JSON));

        TimeSalesQuote[] points = tradeKing.getMarketOperations().getDataPoints("TCKR", 2, 20);
        mockServer.verify();

        assertEquals("First Quote Interval Start Time is Not Equal to mock's", points[0].getIntervalStartTime(), mockData.timeSalesQuote1.getIntervalStartTime());
        assertEquals("First Quote is Not Equal to mock", points[0], mockData.timeSalesQuote1);
        assertEquals("Second Quote is Not Equal to mock", points[1], mockData.timeSalesQuote2);
    }

    @Test
    public void getDataPoints_MultiDay() {
        Calendar startDate = new Calendar.Builder().setDate(2014, 11, 15).build();
        Calendar endDate = new Calendar.Builder().setDate(2014, 11, 20).build();
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/timesales.json?symbols=TCKR&interval=5min&startdate=2014-12-15&enddate=2014-12-20"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/time_sales_quotes"), MediaType.APPLICATION_JSON));
        TimeSalesQuote[] points = tradeKing.getMarketOperations().getDataPoints("TCKR", startDate, endDate, TimeSalesInterval.MINUTES_5);

        mockServer.verify();
        assertEquals("First Quote Interval Start Time is Not Equal to mock's", points[0].getIntervalStartTime(), mockData.timeSalesQuote1.getIntervalStartTime());
        assertEquals("First Quote is Not Equal to mock", points[0], mockData.timeSalesQuote1);
        assertEquals("Second Quote is Not Equal to mock", points[1], mockData.timeSalesQuote2);
    }

    @Test
    public void getDataPoints_SinglePoint() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/timesales.json?symbols=TCKR&interval=tick&rpp=20&index=21"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/time_sales_quote_single"), MediaType.APPLICATION_JSON));

        TimeSalesQuote[] points = tradeKing.getMarketOperations().getDataPoints("TCKR", 2, 20);
        mockServer.verify();

        assertEquals("First Quote Interval Start Time is Not Equal to mock's", points[0].getIntervalStartTime(), mockData.timeSalesQuote1.getIntervalStartTime());
        assertEquals("First Quote is Not Equal to mock", points[0], mockData.timeSalesQuote1);
    }

    @Test(expected = ApiException.class)
    public void getDataPoints_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/timesales.json?symbols=TCKR&interval=tick&rpp=20&index=21"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getDataPoints("TCKR", 2, 20);
        mockServer.verify();
    }

    @Test
    public void getTopList() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/toplists/topactive.json"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/toplist"), MediaType.APPLICATION_JSON));

        TopListEntry[] list = tradeKing.getMarketOperations().getTopList(TopListType.ACTIVE);
        mockServer.verify();

        assertEquals("First top list entry does not match.", list[0], mockData.topListEntry1);
        assertEquals("Second top list entry does not match.", list[1], mockData.topListEntry2);
        assertArrayEquals("Toplist result does not match", list, mockData.topList);
    }

    @Test(expected = ApiException.class)
    public void getTopList_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/toplists/topactive.json"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getTopList(TopListType.ACTIVE);
        mockServer.verify();
    }

    @Test
    public void getNewsById() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/news/4cacd265647adb9a46977d5d2f8ff559.json"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/news_article"), MediaType.APPLICATION_JSON));

        NewsStory newsStory = tradeKing.getMarketOperations().getNewsById("4cacd265647adb9a46977d5d2f8ff559");
        mockServer.verify();

        assertEquals("Dates do not match", newsStory.getDate(), mockData.newsStory.getDate());
        assertEquals("News articles do not match", newsStory, mockData.newsStory);
    }

    @Test(expected = ApiException.class)
    public void getNewsById_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/news/4cacd265647adb9a46977d5d2f8ff559.json"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getNewsById("4cacd265647adb9a46977d5d2f8ff559");
        mockServer.verify();
    }

    @Test
    public void getNewsList_keywords() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/news/search.json?maxhits=2&keywords=oil%2Cmetals"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/news_list"), MediaType.APPLICATION_JSON));

        NewsHeadline[] newsLists = tradeKing.getMarketOperations().getNewsList(new String[]{"oil", "metals"}, 2);
        mockServer.verify();

        assertEquals("First News Headline does not match", newsLists[0], mockData.newsHeadline1);
        assertEquals("Second News Headline does not match", newsLists[1], mockData.newsHeadline2);
        assertArrayEquals("Headlines do not match", newsLists, mockData.newsList);
    }


    @Test
    public void getNewsList_ticker() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/news/search.json?symbols=CORP1&maxhits=1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/news_list_single"), MediaType.APPLICATION_JSON));

        NewsHeadline[] newsLists = tradeKing.getMarketOperations().getNewsList("CORP1", 1);
        mockServer.verify();

        assertEquals("First News Headline does not match", newsLists[0], mockData.newsHeadline1);
    }

    @Test(expected = ApiException.class)
    public void getNewsList_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/news/search.json?symbols=CORP1&maxhits=1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getNewsList("CORP1", 1);
        mockServer.verify();
    }

    @Test
    public void getOptionExpirationDates() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/options/expirations.json?symbol=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/option_expiration_dates"), MediaType.APPLICATION_JSON));

        Calendar[] expirationDates = tradeKing.getMarketOperations().getOptionExpirationDates("CORP1");
        mockServer.verify();

        assertArrayEquals("Dates do not match", expirationDates, mockData.optionExpirationDates);

    }

    @Test
    public void getOptionExpirationDates_single() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/options/expirations.json?symbol=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/option_expiration_date_single"), MediaType.APPLICATION_JSON));

        Calendar[] expirationDates = tradeKing.getMarketOperations().getOptionExpirationDates("CORP1");
        mockServer.verify();

        assertArrayEquals("Dates do not match", expirationDates, new Calendar[]{mockData.optionExpiration1});
    }

    @Test(expected = ApiException.class)
    public void getOptionExpirationDates_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/options/expirations.json?symbol=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getOptionExpirationDates("CORP1");
        mockServer.verify();
    }


    @Test
    public void getOptionStrikePrices() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/options/strikes.json?symbol=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/option_strike_prices"), MediaType.APPLICATION_JSON));

        Double[] strikePrices = tradeKing.getMarketOperations().getStrikePrices("CORP1");
        mockServer.verify();

        assertArrayEquals("Dates do not match", strikePrices, mockData.optionStrikePrices);

    }

    @Test
    public void getOptionStrikePrices_single() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/options/strikes.json?symbol=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/option_strike_price_single"), MediaType.APPLICATION_JSON));

        Double[] strikePrices = tradeKing.getMarketOperations().getStrikePrices("CORP1");
        mockServer.verify();

        assertArrayEquals("Dates do not match", strikePrices, new Double[]{mockData.optionStrikePrice1});
    }

    @Test(expected = ApiException.class)
    public void getOptionStrikePrices_errorResponse() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/options/strikes.json?symbol=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

        tradeKing.getMarketOperations().getStrikePrices("CORP1");
        mockServer.verify();
    }

    @Test
    public void getQuoteForStocks() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/ext/quotes.json?symbols=CORP1%2CCORP2"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/stock_quotes"), MediaType.APPLICATION_JSON));

        StockQuote[] quotes = tradeKing.getMarketOperations().getQuoteForStocks(new String[]{"CORP1", "CORP2"});
        mockServer.verify();

    }

    @Test
    public void getQuoteForStocks_single() {
        mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/ext/quotes.json?symbols=CORP1"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("market/stock_quote_single"), MediaType.APPLICATION_JSON));

        StockQuote quote = tradeKing.getMarketOperations().getQuoteForStock("CORP1");
        mockServer.verify();

    }


}
