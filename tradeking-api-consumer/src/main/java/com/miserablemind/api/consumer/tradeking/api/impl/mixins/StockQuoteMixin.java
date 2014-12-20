/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StockQuoteMixin extends QuoteMixIn {


  @JsonProperty("adp_100")
  double averageDailyPrice100;

  @JsonProperty("adp_200")
  double averageDailyPrice200;

  @JsonProperty("adp_50")
  double averageDailyPrice50;

  @JsonProperty("adv_21")
  double averageDailyPrice21;

  @JsonProperty("adv_30")
  double averageDailyPrice30;

  @JsonProperty("adv_90")
  double averageDailyPrice90;

  @JsonProperty("beta")
  double beta;

  @JsonProperty("bidtick")
  int tickDirectionSinceLastBid;

  @JsonProperty("cusip")
  private String cusip;

  @JsonProperty("div")
  double lastDividend;

  @JsonProperty("divexdate")
  Date exDividendDate;

  @JsonProperty("divfreq")
  char dividendFrequency;

  @JsonProperty("divpaydt")
  Date lastDividendPayDate;

  @JsonProperty("eps")
  double earningsPerShare;

  @JsonProperty("iad")
  double indicatedAnnualDividend;

  @JsonProperty("op_flag")
  int hasOptions;

  @JsonProperty("pr_adp_100")
  double priorAverageDailyPrice100;

  @JsonProperty("pr_adp_200")
  double priorAverageDailyPrice200;

  @JsonProperty("pr_adp_50")
  double priorAverageDailyPrice50;

  @JsonProperty("prbook")
  double bookValuePrice;

  @JsonProperty("sho")
  String sharesOutstanding;

  @JsonProperty("volatility12")
  double oneYearVolatility;

  @JsonProperty("yield")
  double dividendYield;

  @JsonProperty("pe")
  double priceEarning;

}
