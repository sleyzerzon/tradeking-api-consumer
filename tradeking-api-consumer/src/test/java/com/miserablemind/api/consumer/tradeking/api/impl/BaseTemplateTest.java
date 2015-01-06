package com.miserablemind.api.consumer.tradeking.api.impl;


import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.web.client.MockRestServiceServer;

public class BaseTemplateTest {

  protected MockRestServiceServer mockServer;
  protected TradeKingTemplate tradeKing;
  protected TestObjectsRepository mockData;

  @Before
  public void setup() {
    tradeKing = new TradeKingTemplate("API_KEY", "API_SECRET", "ACCESS_TOKEN", "ACCESS_TOKEN_SECRET");
    mockServer = MockRestServiceServer.createServer(tradeKing.getRestTemplate());
    mockData = new TestObjectsRepository();
  }

  protected Resource jsonResource(String filename) {
    return new ClassPathResource(filename + ".json", getClass());
  }

}
