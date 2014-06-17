package com.miserablemind.twtbeat.domain.service.traderking.api.impl;

import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingUser;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

public class TraderKingTemplate extends AbstractOAuth1ApiBinding implements TraderKingOperations {

  private static final String API_URL_BASE = "https://api.tradeking.com/v1/";

  public TraderKingTemplate(String consumerKey, String consumerSecret, String accessToken, String secret) {
    super(consumerKey, consumerSecret, accessToken, secret);
  }

  @Override
  public TraderKingUser getCurrentUser() {
    String user = this.getRestTemplate().getForObject(buildUri("member/profile.json"), String.class);
    return new TraderKingUser();
  }

  @Override
  public void updateStatus() {
    //void
  }


  protected URI buildUri(String path) {
    return buildUri(path, EMPTY_PARAMETERS);
  }

  protected URI buildUri(String path, String parameterName, String parameterValue) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set(parameterName, parameterValue);
    return buildUri(path, parameters);
  }

  protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
    return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
  }

  private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();
}
