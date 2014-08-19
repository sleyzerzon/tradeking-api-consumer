package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.holdings.AccountHoldings;

public class TKAccountHoldingsResponse extends TKResponse {

  private String error;

  @JsonProperty("accountholdings")
  private AccountHoldings accountHoldings;

  public String getError() {
    return error;
  }

  public AccountHoldings getAccountHoldings() {
    return accountHoldings;
  }
}
