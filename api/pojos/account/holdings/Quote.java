package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class Quote extends TKObject {

  private double change;

  private String format;

  @JsonProperty("lastprice")
  private double lastPrice;

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
