/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.miserablemind.api.consumer.tradeking.api.TradeKingOperations;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

public class TradeKingTemplate extends AbstractOAuth1ApiBinding implements TradeKingOperations {


  private AccountTemplate accountOperations;
  private WatchlistTemplate watchlistOperations;
  private MarketTemplate marketOperations;
  private StreamingTemplate streamingOperations;
  private APITemplate apiOperations;


  public TradeKingTemplate(String consumerKey, String consumerSecret, String accessToken, String secret) {
    super(consumerKey, consumerSecret, accessToken, secret);
    initSubAPIs();
  }

  private void initSubAPIs() {
    this.accountOperations = new AccountTemplate(getRestTemplate());
    this.watchlistOperations = new WatchlistTemplate(getRestTemplate());
    this.marketOperations = new MarketTemplate(getRestTemplate());
    this.streamingOperations = new StreamingTemplate(getRestTemplate());
    this.apiOperations = new APITemplate(getRestTemplate());
  }

  @Override
  public AccountTemplate getAccountOperations() {
    return accountOperations;
  }

  @Override
  public WatchlistTemplate getWatchlistOperations() {
    return watchlistOperations;
  }

  @Override
  public MarketTemplate getMarketOperations() {
    return marketOperations;
  }

  @Override
  public StreamingTemplate getStreamingOperations() {
    return streamingOperations;
  }

  @Override
  public APITemplate getAPIOperations() {
    return apiOperations;
  }

  @Override
  protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
    MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
    mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
    mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    mapper.registerModule(new TradeKingModule());

    converter.setObjectMapper(mapper);
    return converter;
  }

}
