/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.holdings;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.List;

/**
 * This class contains a list of the holding entries and a field that has a total
 */
public class AccountHoldings extends TradeKingObject {

  public AccountHoldings() {
  }

  public AccountHoldings(List<AccountHoldingEntry> holdingsList, double totalSecurities) {
    this.holdingsList = holdingsList;
    this.totalSecurities = totalSecurities;
  }

  private List<AccountHoldingEntry> holdingsList;
  private double totalSecurities;

  /**
   * @return list of holding entry objects
   */
  public List<AccountHoldingEntry> getHoldingsList() {
    return holdingsList;
  }

  /**
   * Total of all securities. This is calculated by TK, not this library
   *
   * @return dollar figure
   */
  public double getTotalSecurities() {
    return totalSecurities;
  }
}
