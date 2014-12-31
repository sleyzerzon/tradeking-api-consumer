/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.balance;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * Detailed info about securities hold in the account
 */
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

  /**
   * Total long options market value.
   *
   * @return dollar figure
   */
  public double getLongOptions() {
    return longOptions;
  }

  /**
   * Long stock market value
   *
   * @return dollar figure
   */
  public double getLongStocks() {
    return longStocks;
  }

  /**
   * Short option market value
   *
   * @return dollar figure
   */
  public double getShortOptions() {
    return shortOptions;
  }

  /**
   * Short stock market value
   *
   * @return dollar figure
   */
  public double getShortStocks() {
    return shortStocks;
  }

  /**
   * Total options market value
   *
   * @return dollar figure
   */
  public double getOptions() {
    return options;
  }

  /**
   * Total stock market value
   *
   * @return dollar figure
   */
  public double getStocks() {
    return stocks;
  }

  /**
   * Total market value (stock & option)
   *
   * @return dollar figure
   */
  public double getTotal() {
    return total;
  }
}
