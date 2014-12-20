/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialInstrumentMixIn extends TKObjectMixIn {

  @JsonProperty("cusip")
  String cusip;

  @JsonProperty("desc")
  String description;

  @JsonProperty("factor")
  double factor;

  @JsonProperty("sectyp")
  String securityType;

  @JsonProperty("sym")
  String symbol;
}
