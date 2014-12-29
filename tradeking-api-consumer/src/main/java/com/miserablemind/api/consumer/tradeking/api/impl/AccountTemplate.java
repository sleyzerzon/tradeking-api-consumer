/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;

import com.miserablemind.api.consumer.tradeking.api.AccountOperations;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TradeKingTransaction;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldings;
import com.miserablemind.api.consumer.tradeking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.TKAccountBalanceResponse;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.TKAccountHoldingsResponse;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.TKAllAccountsResponse;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.TKHistoryResponse;
import com.miserablemind.api.consumer.tradeking.connect.TradeKingServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.social.ApiException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class AccountTemplate extends BaseTemplate implements AccountOperations {

  private static final String URL_ACCOUNTS = "accounts.json";
  private static final String URL_ACCOUNT_BALANCES = "accounts/%s/balances.json";
  private static final String URL_ACCOUNT_HOLDINGS = "accounts/%s/holdings.json";
  private static final String URL_ACCOUNT_HISTORY = "accounts/%s/history.json";


  AccountTemplate(RestTemplate restTemplate) {
    super(restTemplate);
  }

  @Override
  public AccountsSummary[] getAccount() {

    URI url = this.buildUri(URL_ACCOUNTS);
    ResponseEntity<TKAllAccountsResponse> response = this.getRestTemplate().getForEntity(url, TKAllAccountsResponse.class);

    if (response.getBody().getError() != null)
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getAccounts();
  }

  @Override
  public AccountBalance getAccountBalance(String accountId) {
    URI url = this.buildUri(String.format(URL_ACCOUNT_BALANCES, accountId));
    ResponseEntity<TKAccountBalanceResponse> response = this.getRestTemplate().getForEntity(url, TKAccountBalanceResponse.class);
    if (!response.getBody().getError().equals("Success"))
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getAccountBalance();
  }

  @Override
  public AccountHoldings getAccountHoldings(String accountId) {
    URI url = this.buildUri(String.format(URL_ACCOUNT_HOLDINGS, accountId));
    ResponseEntity<TKAccountHoldingsResponse> response = this.getRestTemplate().getForEntity(url, TKAccountHoldingsResponse.class);
    if (!response.getBody().getError().equals("Success"))
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getAccountHoldings();
  }

  @Override
  public TradeKingTransaction[] getTransactionsHistory(String accountId, TradeKingTransaction.Range range, TradeKingTransaction.Type type) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set("range", range.toString());
    parameters.set("transactions", type.toString());

    URI url = this.buildUri(String.format(URL_ACCOUNT_HISTORY, accountId), parameters);
    ResponseEntity<TKHistoryResponse> response = this.getRestTemplate().getForEntity(url, TKHistoryResponse.class);
    if (null != response.getBody().getError())
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());
    return response.getBody().getTransactionHistory();
  }

  @Override
  public void updateStatus() {
    //void
  }


}
