/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

public class TimeSalesQuoteMixIn {

  @JsonProperty("date")
  Calendar date;

  @JsonProperty("datetime")
  Calendar intervalStartTime;

  @JsonProperty("hi")
  double highPrice;

  @JsonProperty("lo")
  double lowPrice;

  @JsonProperty("incr_vl")
  int volume;

  @JsonProperty("last")
  double lastPrice;

  @JsonProperty("opn")
  double openTradePrice;

  @JsonProperty("timestamp")
  int timestamp;

  @JsonProperty("vl")
  int cumulativeVolume;

}
