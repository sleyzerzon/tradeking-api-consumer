package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.BuyingPower;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.Cash;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.Securities;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class AccountTemplateTest extends BaseTemplateTest {

  Cash testCash = new Cash(0.0, 9.83, 10.98, 0.0, 0.0, 10.98, 0.0, 0.0, 0.0);
  BuyingPower testBuyingPower = new BuyingPower(26.63, 100, 26.63, 26.63, 53.26, 53.26);
  Securities testSecurities = new Securities(0.0, 26.48, 0.0, 0.0, 0.0, 26.48, 26.48);
  AccountBalance testBalance = new AccountBalance(accountId, 36.46, 0.0, testBuyingPower, 0.0, 0.0, 26.63, testCash, testSecurities);

  @Test
  public void getAccountBalance() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "accounts/" + accountId + "/balances.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("account_balance"), MediaType.APPLICATION_JSON));
    AccountBalance jsonBalance = tradeKing.getAccountOperations().getAccountBalance(accountId);

    assertEquals("Cash Objects are not equal", jsonBalance.getCashSummary(), testCash);
    assertEquals("Buying Power Objects are not equal", jsonBalance.getBuyingPowerSummary(), testBuyingPower);
    assertEquals("Securities Objects are not equal", jsonBalance.getSecuritiesSummary(), testSecurities);
    assertEquals("Account Balance Objects are not equal", jsonBalance, testBalance);
  }

}
