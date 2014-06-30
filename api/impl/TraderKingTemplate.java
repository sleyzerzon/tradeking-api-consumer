package com.miserablemind.twtbeat.domain.service.traderking.api.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TKTransactionHistoryEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TransactionHistory;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary.TKAllAccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.TKUser;
import com.miserablemind.twtbeat.domain.service.traderking.api.response_entities.*;
import com.miserablemind.twtbeat.domain.service.traderking.connect.TraderKingServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.ApiException;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

public class TraderKingTemplate extends AbstractOAuth1ApiBinding implements TraderKingOperations {

  private static final String API_URL_BASE = "https://api.tradeking.com/v1/";

  public TraderKingTemplate(String consumerKey, String consumerSecret, String accessToken, String secret) {
    super(consumerKey, consumerSecret, accessToken, secret);
    //todo: a little fishy number two
    MappingJackson2HttpMessageConverter converter = (MappingJackson2HttpMessageConverter) this.getRestTemplate().getMessageConverters().get(2);
    converter.getObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
  }

  @Override
  public TKUser getCurrentUser() {
    ResponseEntity<TKUserResponse> response = this.getRestTemplate().getForEntity(this.buildUri("member/profile.json"), TKUserResponse.class);
    if (response.getBody().getError().equals("success"))
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getUserdata();
  }

  @Override
  public TKAllAccountsSummary getAccount() {

    ResponseEntity<TKAllAccountsResponse> response = this.getRestTemplate().getForEntity(this.buildUri("accounts.json"), TKAllAccountsResponse.class);

    if (response.getBody().getError() != null)
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getAccounts().getAccountSummary();

  }

  @Override
  public AccountBalance getAccountBalance(String accountId) {
    ResponseEntity<TKAccountBalanceResponse> response = this.getRestTemplate().getForEntity(this.buildUri("accounts/" + accountId + "/balances.json"), TKAccountBalanceResponse.class);
    if (!response.getBody().getError().equals("Success"))
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getAccountBalance();
  }

  @Override
  public AccountHoldings getAccountHoldings(String accountId) {
    ResponseEntity<TKAccountHoldingsResponse> response = this.getRestTemplate().getForEntity(this.buildUri("accounts/" + accountId + "/holdings.json"), TKAccountHoldingsResponse.class);
    if (!response.getBody().getError().equals("Success"))
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getAccountHoldings();
  }

  @Override
  public TransactionHistory getAllHistory(String accountId) {

    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set("range", TKTransactionHistoryEntry.TRANSACTION_RANGE_ALL);
    parameters.set("transactions", TKTransactionHistoryEntry.TRANSACTION_TYPE_ALL.toLowerCase());

    // ResponseEntity<String> response = this.getRestTemplate().getForEntity(this.buildUri("accounts/" + accountId + "/history.json", parameters), String.class);
    ResponseEntity<TKHistoryResponse> response = this.getRestTemplate().getForEntity(this.buildUri("accounts/" + accountId + "/history.json", parameters), TKHistoryResponse.class);
    if (null != response.getBody().getError())
      throw new ApiException(TraderKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getTransactionHistory();

    //return null;
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
