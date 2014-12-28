/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Calendar;

@JsonRootName("quote")
public class StreamQuoteMixIn {

  @JsonProperty("ask")
  double askPrice;

  @JsonProperty("asksz")
  int askLatestSizeHundreds;

  @JsonProperty("bid")
  double bidPriceHundreds;

  @JsonProperty("bidsz")
  int bidLatestSize;

  @JsonProperty("bidtick")
  int bidTick;

  @JsonProperty("datetime")
  Calendar dateTime;

  @JsonProperty("exch")
  String exchangeCode;

  @JsonProperty("qcond")
  String conditionCode;

  @JsonProperty("symbol")
  String symbol;

  @JsonProperty("timestamp")
  int timeStamp;
}