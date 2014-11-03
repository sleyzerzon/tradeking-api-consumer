package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.OptionQuote;

import java.util.Date;

public class OptionQuoteMixIn extends QuoteMixIn {

  @JsonProperty("contract_size")
  int contractSize;

  @JsonProperty("days_to_expiration")
  int daysToExpiration;

  @JsonProperty("imp_volatility")
  private double impliedVolatility;

  @JsonProperty("idelta")
  private double iDelta;

  @JsonProperty("igamma")
  private double iGamma;

  @JsonProperty("irho")
  private double iRho;

  @JsonProperty("itheta")
  private double iTheta;

  @JsonProperty("ivega")
  private double iVega;

  @JsonProperty("issue_desc")
  String fullDescription;

  @JsonProperty("op_delivery")
  OptionQuote.OptionDelivery optionDelivery;

  @JsonProperty("op_style")
  OptionQuote.OptionStyle optionStyle;

  @JsonProperty("op_subclass")
  OptionQuote.OptionClass optionClass;

  @JsonProperty("openinterest")
  String openInterest;

  @JsonProperty("pr_openinterest")
  String priorDayOpenInterest;

  @JsonProperty("opt_val")
  double optionValueCalculation;

  @JsonProperty("prem_mult")
  double optionPremiumMultiplier;

  @JsonProperty("put_call")
  OptionQuote.OptionType optionType;

  @JsonProperty("rootsymbol")
  String optionRootSymbol;

  @JsonProperty("strikeprice")
  double strikePrice;

  @JsonProperty("under_cusip")
  String underlyingCusip;

  @JsonProperty("undersymbol")
  String underlyingSymbol;

  @JsonProperty("xdate")
  Date expirationDate;

  @JsonProperty("xday")
  String expirationDay;

  @JsonProperty("xmonth")
  String expirationMonth;

  @JsonProperty("xyear")
  String expirationYear;
}
