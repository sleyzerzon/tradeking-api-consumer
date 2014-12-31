/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.holdings;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * A very brief quote object that is returned within Holdings entry
 */
public class HoldingsQuote extends TradeKingObject {

  private double change;
  private double lastPrice;

  public HoldingsQuote() {
  }

  public HoldingsQuote(double change, double lastPrice) {
    this.change = change;
    this.lastPrice = lastPrice;
  }

  /**
   * Holding asset change for the day
   *
   * @return dollar amount change
   */
  public double getChange() {
    return change;
  }

  /**
   * Last Price of instrument
   *
   * @return dollar amount of last price
   */
  public double getLastPrice() {
    return lastPrice;
  }
}
