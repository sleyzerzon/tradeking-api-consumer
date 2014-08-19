package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.balance.AccountBalance;

public class TKAccountBalanceResponse extends TKResponse {

  private String error;

  @JsonProperty("accountbalance")
  private AccountBalance accountBalance;

  public String getError() {
    return error;
  }

  public AccountBalance getAccountBalance() {
    return accountBalance;
  }
}
