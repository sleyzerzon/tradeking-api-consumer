package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;


public class Securities extends TKObject {

  @JsonProperty("longoptions")
  private double longOptions;

  @JsonProperty("longstocks")
  private double longStocks;

  @JsonProperty("shortoptions")
  private double shortOptions;

  @JsonProperty("shortstocks")
  private double shortStocks;

  private double options;
  private double stocks;
  private double total;

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
