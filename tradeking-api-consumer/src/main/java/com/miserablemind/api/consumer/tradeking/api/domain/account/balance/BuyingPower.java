/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.balance;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * Holds data about buying power for stocks and options
 */
public class BuyingPower extends TradeKingObject {

  private double cashAvailableForWithdrawal;
  private double equityPercentage;
  private double options;
  private double sodOptions;
  private double sodStock;
  private double stock;

  public BuyingPower() {
  }

  public BuyingPower(double cashAvailableForWithdrawal, double equityPercentage, double options, double sodOptions, double sodStock, double stock) {
    this.cashAvailableForWithdrawal = cashAvailableForWithdrawal;
    this.equityPercentage = equityPercentage;
    this.options = options;
    this.sodOptions = sodOptions;
    this.sodStock = sodStock;
    this.stock = stock;
  }

  /**
   * Cash available for withdrawal (cash & margin accounts only, n/a for retirement accounts)
   *
   * @return dollar figure of cash available for withdrawal
   */
  public double getCashAvailableForWithdrawal() {
    return cashAvailableForWithdrawal;
  }

  /**
   * Percentage of equity (margin accounts only)
   *
   * @return percentage figure
   */
  public double getEquityPercentage() {
    return equityPercentage;
  }

  /**
   * Options buying power.
   *
   * @return a dollar figure
   */
  public double getOptions() {
    return options;
  }

  /**
   * Start of day options buying power
   *
   * @return a dollar figure
   */
  public double getSodOptions() {
    return sodOptions;
  }

  /**
   * Start of day stock buying power
   *
   * @return a dollar figure
   */
  public double getSodStock() {
    return sodStock;
  }

  /**
   * Stock buying power
   *
   * @return a dollar figure
   */
  public double getStock() {
    return stock;
  }
}
