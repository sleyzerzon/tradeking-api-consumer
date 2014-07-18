package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
//todo : something does not get mapped

public class Cash extends TKObject {

  private double accruedInterest;
  private double cash;
  private double marginBalance;
  private double cashAvailable;
  private double moneyMarketFund;
  private double total;
  private double unclearedDeposits;
  private double unsettledFunds;
  private double yield;

  public Cash() {
  }

  public Cash(double accruedInterest, double cash, double marginBalance, double cashAvailable, double moneyMarketFund, double total, double unclearedDeposits, double unsettledFunds, double yield) {
    this.accruedInterest = accruedInterest;
    this.cash = cash;
    this.marginBalance = marginBalance;
    this.cashAvailable = cashAvailable;
    this.moneyMarketFund = moneyMarketFund;
    this.total = total;
    this.unclearedDeposits = unclearedDeposits;
    this.unsettledFunds = unsettledFunds;
    this.yield = yield;
  }

  public double getAccruedInterest() {
    return accruedInterest;
  }

  public double getCash() {
    return cash;
  }

  public double getMarginBalance() {
    return marginBalance;
  }

  public double getCashAvailable() {
    return cashAvailable;
  }

  public double getMoneyMarketFund() {
    return moneyMarketFund;
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
