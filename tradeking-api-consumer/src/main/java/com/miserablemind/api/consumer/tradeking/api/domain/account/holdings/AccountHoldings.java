/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.holdings;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.List;

public class AccountHoldings extends TradeKingObject {

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
