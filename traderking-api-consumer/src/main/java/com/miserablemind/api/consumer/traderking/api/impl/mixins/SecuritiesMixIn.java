package com.miserablemind.api.consumer.traderking.api.impl.mixins;

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
