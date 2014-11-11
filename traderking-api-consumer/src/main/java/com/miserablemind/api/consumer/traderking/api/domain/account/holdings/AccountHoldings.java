package com.miserablemind.api.consumer.traderking.api.domain.account.holdings;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

import java.util.List;

public class AccountHoldings extends TKObject {

  public AccountHoldings() {
  }

  public AccountHoldings(List<AccountHoldingEntry> holdingsList, double totalSecurities) {
    this.holdingsList = holdingsList;
    this.totalSecurities = totalSecurities;
  }

  private List<AccountHoldingEntry> holdingsList;
  private double totalSecurities;

  public List<AccountHoldingEntry> getHoldingsList() {
    return holdingsList;
  }

  public double getTotalSecurities() {
    return totalSecurities;
  }
}
