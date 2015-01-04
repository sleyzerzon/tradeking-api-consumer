package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldings;
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
      .andRespond(withSuccess(jsonResource("account/summary_single"), MediaType.APPLICATION_JSON));
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
  public void getAccount_multiple() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("account/summary_multiple"), MediaType.APPLICATION_JSON));
    AccountsSummary[] accounts = tradeKing.getAccountOperations().getAccounts();

    assertEquals("Summary 1 Objects are not equal", accounts[0], mockData.accountsSummary1);
    assertEquals("Summary 2 Objects are not equal", accounts[1], mockData.accountsSummary2);
  }

  @Test
  public void getAccountBalance() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts/" + mockData.accountId + "/balances.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("account/balance"), MediaType.APPLICATION_JSON));
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

  @Test
  public void getAccountHoldings_multiple() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts/" + mockData.accountId + "/holdings.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("account/holding_multiple"), MediaType.APPLICATION_JSON));
    AccountHoldings jsonHoldings = tradeKing.getAccountOperations().getAccountHoldings(mockData.accountId);

    assertEquals("AccountHoldings Objects are not equal", jsonHoldings, mockData.holdings);
  }


}
