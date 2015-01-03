package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.summary.AccountsSummary;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.ApiException;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class AccountTemplateTest extends BaseTemplateTest {


  @Test
  public void getAccount_singleAccount() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("account/account_summary_single"), MediaType.APPLICATION_JSON));
    AccountsSummary[] accounts = tradeKing.getAccountOperations().getAccounts();
    AccountsSummary account = accounts[0];

    assertEquals("Balance objects are not equal", account.getAccountBalance(), mockData.accountsSummary1.getAccountBalance());
    assertEquals("Holdings objects are not equal", account.getAccountHoldings(), mockData.accountsSummary1.getAccountHoldings());
    assertEquals("Summary Objects are not equal", account, mockData.accountsSummary1);
  }

  @Test(expected = ApiException.class)
  public void getAccount_errorResponse() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));
    AccountsSummary[] accounts = tradeKing.getAccountOperations().getAccounts();
  }

  @Test
  public void getAccountBalance() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts/" + mockData.accountId + "/balances.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("account/account_balance"), MediaType.APPLICATION_JSON));
    AccountBalance jsonBalance = tradeKing.getAccountOperations().getAccountBalance(mockData.accountId);

    assertEquals("Cash Objects are not equal", jsonBalance.getCashSummary(), mockData.cash);
    assertEquals("Buying Power Objects are not equal", jsonBalance.getBuyingPowerSummary(), mockData.buyingPower);
    assertEquals("Securities Objects are not equal", jsonBalance.getSecuritiesSummary(), mockData.securities);
    assertEquals("Account Balance Objects are not equal", jsonBalance, mockData.balance);
  }

  @Test(expected = ApiException.class)
  public void getAccountBalance_errorResponse() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts/" + mockData.accountId + "/balances.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));
    AccountBalance jsonBalance = tradeKing.getAccountOperations().getAccountBalance(mockData.accountId);
  }


}
