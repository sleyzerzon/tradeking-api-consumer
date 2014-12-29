/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.holdings;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

public class HoldingsQuote extends TradeKingObject {

  private double change;
  private String format;
  private double lastPrice;

  public HoldingsQuote() {
  }

  public HoldingsQuote(double change, String format, double lastPrice) {
    this.change = change;
    this.format = format;
    this.lastPrice = lastPrice;
  }

  public double getChange() {
    return change;
  }

  public String getFormat() {
    return format;
  }

  public double getLastPrice() {
    return lastPrice;
  }
}
