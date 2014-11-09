package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.ChangeSign;

public class TopListEntryMixIn extends TKObjectMixIn {

  @JsonProperty("chg")
  double change;

  @JsonProperty("chg_sign")
  ChangeSign changeDirection;

  @JsonProperty("last")
  double lastTradePrice;

  @JsonProperty("name")
  String companyName;

  @JsonProperty("pchg")
  String percentageChange;

  @JsonProperty("pcls")
  double priorDayClosePrice;

  @JsonProperty("rank")
  int rankInTheList;

  @JsonProperty("symbol")
  String ticker;

  @JsonProperty("vl")
  int volume;

}
