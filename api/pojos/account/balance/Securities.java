package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;


public class Securities extends TKObject {

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
