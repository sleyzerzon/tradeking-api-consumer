/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.market.ChangeSign;
import com.miserablemind.api.consumer.traderking.api.domain.market.Quote;

import java.util.Date;

abstract public class QuoteMixIn extends TKObjectMixIn {

  @JsonProperty("ask_time")
  String askTime;

  @JsonProperty("asksz")
  int askLatestSize;

  @JsonProperty("bid_time")
  String bidTime;

  @JsonProperty("bidsz")
  int bidLatestSize;

  @JsonProperty("chg")
  double change;

  @JsonProperty("chg_sign")
  ChangeSign changeSign;

  @JsonProperty("chg_t")
  String changeText;

  @JsonProperty("cl")
  double previousClose;

  @JsonProperty("date")
  Date dateLastTrade;

  @JsonProperty("date_time")
  Date timeLastTrade;

  @JsonProperty("dollar_value")
  double volumeToday;

  @JsonProperty("exch")
  String exchangeCode;

  @JsonProperty("exch_desc")
  String exchangeDescription;

  @JsonProperty("hi")
  double dayHigh;

  @JsonProperty("incr_vl")
  int volumeLastTrade;

  @JsonProperty("last")
  double lastPrice;

  @JsonProperty("lo")
  double dayLow;

  @JsonProperty("name")
  String companyName;

  @JsonProperty("opn")
  double openPrice;

  @JsonProperty("opn")
  double openTradePrice;

  @JsonProperty("pchg")
  String changePercentage;

  @JsonProperty("pchg_sign")
  String changePercentageSign;

  @JsonProperty("pcls")
  double priorDayClose;

  @JsonProperty("phi")
  double priorDayHigh;

  @JsonProperty("plo")
  double priorDayLow;

  @JsonProperty("pr_date")
  Date dateOfPriorTradeDay;

  @JsonProperty("popn")
  double priorDayOpen;

  @JsonProperty("prchg")
  double priorDayChange;

  @JsonProperty("pvol")
  int priodDayVolume;

  @JsonProperty("secclass")
  Quote.SecurityClass securityClass;

  @JsonProperty("sesn")
  Quote.TradingSession tradingSession;

  @JsonProperty("symbol")
  String symbol;

  @JsonProperty("tcond")
  Quote.TradeCondition tradeCondition;

  @JsonProperty("timestamp")
  Date timeStamp;

  @JsonProperty("tr_num")
  int tradeCountSinceOpen;

  @JsonProperty("tradetick")
  char tradeDirection;

  @JsonProperty("trend")
  String trendOf10LastTicks;

  @JsonProperty("vl")
  int cumulativeVolume;

  @JsonProperty("vwap")
  double volumeWeightedAveragePrice;

  @JsonProperty("wk52hi")
  double week52high;

  @JsonProperty("wk52hidate")
  Date week52highDate;

  @JsonProperty("wk52lodate")
  Date week52lowDate;

  @JsonProperty("wk52lo")
  double week52low;

  @JsonProperty("datetime")
  Date dateTime;

  @JsonProperty("sesn_vl")
  int sessionVolume;

  @JsonProperty("qcond")
  String quoteConditionCode;

}
