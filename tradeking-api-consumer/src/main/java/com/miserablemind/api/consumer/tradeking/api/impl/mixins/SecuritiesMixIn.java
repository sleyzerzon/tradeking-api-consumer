/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecuritiesMixIn extends TKObjectMixIn {

  @JsonProperty("longoptions")
  double longOptions;

  @JsonProperty("longstocks")
  double longStocks;

  @JsonProperty("shortoptions")
  double shortOptions;

  @JsonProperty("shortstocks")
  double shortStocks;

  @JsonProperty("options")
  double options;

  @JsonProperty("stocks")
  private double stocks;

  @JsonProperty("total")
  private double total;
}
