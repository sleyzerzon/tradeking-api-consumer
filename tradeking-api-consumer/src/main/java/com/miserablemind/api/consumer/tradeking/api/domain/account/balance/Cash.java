/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.balance;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * Holds data about cash in the account
 */
public class Cash extends TradeKingObject {

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

  /**
   * Amount of any accrued interest on the account
   *
   * @return dollar figure
   */
  public double getAccruedInterest() {
    return accruedInterest;
  }

  /**
   * Cash
   *
   * @return dollar figure
   */
  public double getCash() {
    return cash;
  }

  /**
   * Margin balance (- indicates debit balance, + indicates credit balance)
   *
   * @return dollar figure
   */
  public double getMarginBalance() {
    return marginBalance;
  }

  /**
   * Cash available
   *
   * @return dollar figure
   */
  public double getCashAvailable() {
    return cashAvailable;
  }

  /**
   * Money market fund (mmf)
   *
   * @return dollar figure
   */
  public double getMoneyMarketFund() {
    return moneyMarketFund;
  }

  /**
   * Total cash balance
   *
   * @return dollar figure
   */
  public double getTotal() {
    return total;
  }

  /**
   * Uncleared deposits.
   *
   * @return dollar figure
   */
  public double getUnclearedDeposits() {
    return unclearedDeposits;
  }

  /**
   * Unsettled Funds
   *
   * @return dollar figure
   */
  public double getUnsettledFunds() {
    return unsettledFunds;
  }

  /**
   * Yield
   *
   * @return dollar figure (?)
   */
  public double getYield() {
    return yield;
  }
}
