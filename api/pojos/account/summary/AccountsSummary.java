package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;

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
