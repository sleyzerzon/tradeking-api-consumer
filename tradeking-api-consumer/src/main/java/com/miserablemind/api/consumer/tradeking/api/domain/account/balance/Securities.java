/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.balance;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

public class Securities extends TradeKingObject {

  private double longOptions;
  private double longStocks;
  private double shortOptions;
  private double shortStocks;
  private double options;
  private double stocks;
  private double total;

  public Securities() {
  }

  public Securities(double longOptions, double longStocks, double shortOptions, double shortStocks, double options, double stocks, double total) {
    this.longOptions = longOptions;
    this.longStocks = longStocks;
    this.shortOptions = shortOptions;
    this.shortStocks = shortStocks;
    this.options = options;
    this.stocks = stocks;
    this.total = total;
  }

  public double getLongOptions() {
    return longOptions;
  }

  public double getLongStocks() {
    return longStocks;
  }

  public double getShortOptions() {
    return shortOptions;
  }

  public double getShortStocks() {
    return shortStocks;
  }

  public double getOptions() {
    return options;
  }

  public double getStocks() {
    return stocks;
  }

  public double getTotal() {
    return total;
  }
}
