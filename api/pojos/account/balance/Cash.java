package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;


public class Cash extends TKObject {

  @JsonProperty("accruedinterest")
  private double accruedInterest;

  private double cash;

  @JsonProperty("marginbalance")
  private double marginbalance;

  @JsonProperty("cashavailable")
  private double cashAvailable;

  @JsonProperty("mmf")
  private double moneMarketFund;

  private double total;

  @JsonProperty("uncleareddeposits")
  private double unclearedDeposits;

  @JsonProperty("unsettledfunds")
  private double unsettledFunds;

  private double yield;

  public double getAccruedInterest() {
    return accruedInterest;
  }

  public double getCash() {
    return cash;
  }

  public double getMarginbalance() {
    return marginbalance;
  }

  public double getCashAvailable() {
    return cashAvailable;
  }

  public double getMoneMarketFund() {
    return moneMarketFund;
  }

  public double getTotal() {
    return total;
  }

  public double getUnclearedDeposits() {
    return unclearedDeposits;
  }

  public double getUnsettledFunds() {
    return unsettledFunds;
  }

  public double getYield() {
    return yield;
  }
}
