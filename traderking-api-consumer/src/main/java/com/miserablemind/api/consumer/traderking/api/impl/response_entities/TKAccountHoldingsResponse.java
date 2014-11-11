/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.account.holdings.AccountHoldings;

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
