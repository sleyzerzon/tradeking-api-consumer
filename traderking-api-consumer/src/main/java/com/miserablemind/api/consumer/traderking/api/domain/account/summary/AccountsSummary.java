/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.domain.account.summary;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.traderking.api.domain.account.holdings.AccountHoldings;

public class AccountsSummary extends TKObject {

  private String accountId;
  private AccountBalance accountBalance;
  private AccountHoldings accountHoldings;

  public AccountsSummary() {
  }

  public AccountsSummary(String accountId, AccountBalance accountBalance, AccountHoldings accountHoldings) {
    this.accountId = accountId;
    this.accountBalance = accountBalance;
    this.accountHoldings = accountHoldings;
  }

  public String getAccountId() {
    return accountId;
  }

  public AccountBalance getAccountBalance() {
    return accountBalance;
  }

  public AccountHoldings getAccountHoldings() {
    return accountHoldings;
  }
}
