package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.market.MarketStatus;
import com.miserablemind.api.consumer.tradeking.api.domain.market.TimeSalesQuote;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.ApiException;

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

    assertEquals("MarketStatus Dates are not equal", status.getDate(), mockData.marketStatus.getDate());
    assertEquals("MarketStatus objects are not equal", status, mockData.marketStatus);
  }

  @Test(expected = ApiException.class)
  public void getMarketStatus_errorResponse() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/clock.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

    MarketStatus status = tradeKing.getMarketOperations().getMarketStatus();
  }

  //todo: make sure only one quote works too
  @Test
  public void getDataPoints_Tick() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "market/timesales.json?symbols=TCKR&interval=tick&rpp=20&index=21"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("market/time_sales_quotes"), MediaType.APPLICATION_JSON));

    TimeSalesQuote[] points = tradeKing.getMarketOperations().getDataPoints("TCKR", 2, 20);

    assertEquals("First Quote Interval Start Time is Not Equal to mock's", points[0].getIntervalStartTime(), mockData.timeSalesQuote1.getIntervalStartTime());
    assertEquals("First Quote is Not Equal to mock", points[0], mockData.timeSalesQuote1);
    assertEquals("Second Quote is Not Equal to mock", points[1], mockData.timeSalesQuote2);
  }


}
