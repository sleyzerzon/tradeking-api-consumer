package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

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
