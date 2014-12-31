/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoldingQuoteMixIn extends TradeKingKObjectMixIn {

  @JsonProperty("change")
  private double change;

  @JsonProperty("lastprice")
  private double lastPrice;

}
