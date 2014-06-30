package com.miserablemind.twtbeat.domain.service.traderking.api.response_entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;

@JsonRootName("response")
public class TKAccountBalanceResponse extends TKObject {

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
