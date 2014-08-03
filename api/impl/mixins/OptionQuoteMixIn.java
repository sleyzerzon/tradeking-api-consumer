package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class OptionQuoteMixIn extends QuoteMixIn {

  @JsonProperty("contract_size")
  int contract_size;

  @JsonProperty("days_to_expiration")
  int daystToExparation;


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
  char optionDelivery;

  @JsonProperty("op_style")
  char optionStyle;

  @JsonProperty("op_subclass")
  int optionClass;

  @JsonProperty("openinterest")
  String openInterest;

  @JsonProperty("pr_openinterest")
  String priorDayOpenInterest;

  @JsonProperty("opt_val")
  double optionValueCalculation;

  @JsonProperty("prem_mult")
  double optionPremiumMultiplier;

  @JsonProperty("put_call")
  String optionType;

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
