package com.miserablemind.api.consumer.traderking.api.domain.account.balance;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

public class BuyingPower extends TKObject {

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

  public double getCashAvailableForWithdrawal() {
    return cashAvailableForWithdrawal;
  }

  public double getEquityPercentage() {
    return equityPercentage;
  }

  public double getOptions() {
    return options;
  }

  public double getSodOptions() {
    return sodOptions;
  }

  public double getSodStock() {
    return sodStock;
  }

  public double getStock() {
    return stock;
  }
}
