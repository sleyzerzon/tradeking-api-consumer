package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.LinkedHashMap;

/**
 * Miserable Mind
 * http://www.butter.miserablemind.com
 * GNU GENERAL PUBLIC LICENSE Version 2
 */
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
