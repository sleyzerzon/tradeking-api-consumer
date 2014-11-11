/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.traderking.api.domain.account.summary.AccountsSummary;

import java.util.LinkedHashMap;

public class TKAllAccountsResponse extends TKResponse {


  private String error;

  private AccountsSummary[] accounts;

  public String getError() {
    return error;
  }

  public AccountsSummary[] getAccounts() {
    return accounts;
  }

  @JsonSetter("accounts")
  public void setAccounts(LinkedHashMap accountsResponse) throws Exception {
    this.accounts = (AccountsSummary[]) this.extractArray(AccountsSummary[].class, accountsResponse, "accountsummary", null);
  }

}

