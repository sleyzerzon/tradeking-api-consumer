package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

import java.util.List;

public class AccountHoldings extends TKObject {

  @JsonProperty("holding")
  private List<AccountHoldingEntry> holdingsList;

  @JsonProperty("totalsecurities")
  private double totalSecurities;

  public List<AccountHoldingEntry> getHoldingsList() {
    return holdingsList;
  }

  public double getTotalSecurities() {
    return totalSecurities;
  }
}
