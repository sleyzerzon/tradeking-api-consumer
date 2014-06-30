package com.miserablemind.twtbeat.domain.service.traderking.api.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;

@JsonRootName("response")
public class TKAccountHoldingsResponse extends TKObject {

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
