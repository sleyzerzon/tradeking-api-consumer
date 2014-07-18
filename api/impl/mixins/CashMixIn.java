package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashMixIn extends TKObjectMixIn {

  @JsonProperty("accruedinterest")
  double accruedInterest;

  @JsonProperty("cash")
  double cash;

  @JsonProperty("marginbalance")
  double marginBalance;

  @JsonProperty("cashavailable")
  double cashAvailable;

  @JsonProperty("mmf")
  double moneyMarketFund;

  @JsonProperty("total")
  double total;

  @JsonProperty("uncleareddeposits")
  double unclearedDeposits;

  @JsonProperty("unsettledfunds")
  double unsettledFunds;

  @JsonProperty("yield")
  double yield;

}
