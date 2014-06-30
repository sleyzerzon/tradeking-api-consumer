package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;


public class BuyingPower extends TKObject {

  private double cashavailableforwithdrawal;
  private double equitypercentage;
  private double options;
  private double sodoptions;
  private double sodstock;
  private double stock;

  public double getCashavailableforwithdrawal() {
    return cashavailableforwithdrawal;
  }

  public double getEquitypercentage() {
    return equitypercentage;
  }

  public double getOptions() {
    return options;
  }

  public double getSodoptions() {
    return sodoptions;
  }

  public double getSodstock() {
    return sodstock;
  }

  public double getStock() {
    return stock;
  }
}
