/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.LinkedHashMap;

public class TKOptionStrikesResponse extends TKResponse {

  private String error;

  private Double[] prices;

  @JsonSetter("prices")
  public void setPrices(LinkedHashMap pricesResponse) throws Exception {
    this.prices = (Double[]) this.extractArray(Double[].class, pricesResponse, "price", null);
  }

  public String getError() {
    return error;
  }

  public Double[] getPrices() {
    return prices;
  }

}