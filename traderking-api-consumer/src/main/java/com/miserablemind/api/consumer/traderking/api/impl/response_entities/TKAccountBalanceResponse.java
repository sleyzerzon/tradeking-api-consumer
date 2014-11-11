/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.AccountBalance;

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
