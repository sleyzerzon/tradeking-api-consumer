package com.miserablemind.api.consumer.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoldingQuoteMixIn extends TKObjectMixIn {

  @JsonProperty("change")
  private double change;

  @JsonProperty("format")
  private String format;

  @JsonProperty("lastprice")
  private double lastPrice;

}
