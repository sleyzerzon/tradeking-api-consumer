package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Calendar;


/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

@JsonRootName("trade")
public class StreamTradeMixIn extends TKObjectMixIn {

  @JsonProperty("symbol")
  String symbol;

  @JsonProperty("exch")
  String exchangeCode;

  @JsonProperty("last")
  double lastPrice;

  @JsonProperty("vl")
  int volume;

  @JsonProperty("cvol")
  int cumulativeVolume;

  @JsonProperty("vwap")
  double volumeWeightedAveragePrice;

  @JsonProperty("datetime")
  Calendar dateTime;

  @JsonProperty("tcond")
  String tradeCondition;

  @JsonProperty("timestamp")
  int timeStamp;


}
