package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionSecurityMixIn extends TKObjectMixIn {

  @JsonProperty("cusip")
  String cusip;

  @JsonProperty("id")
  String id;

  @JsonProperty("sectyp")
  String securityType;

  @JsonProperty("sym")
  String symbol;

}
