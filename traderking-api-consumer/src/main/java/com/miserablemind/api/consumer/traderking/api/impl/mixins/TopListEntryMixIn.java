/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.mixins;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.market.ChangeSign;

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
