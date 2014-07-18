package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;


import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class HoldingsQuote extends TKObject {

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
