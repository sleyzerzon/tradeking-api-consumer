package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Miserable Mind
 * http://www.butter.miserablemind.com
 * GNU GENERAL PUBLIC LICENSE Version 2
 */
public class TKOptionStrikesResponse extends TKResponse {

  private String error;

  private double[] prices;

  @JsonSetter("prices")
  public void setPrices(LinkedHashMap pricesResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    Object pricesContainer = pricesResponse.get("price");

    String jsonArray = mapper.writeValueAsString(pricesContainer);

    if (pricesContainer.getClass() == ArrayList.class)
      this.prices = mapper.readValue(jsonArray, double[].class);
    else this.prices = new double[]{mapper.readValue(jsonArray, double.class)};

  }

  public String getError() {
    return error;
  }

  public double[] getPrices() {
    return prices;
  }

}
