/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.balance;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

public class AccountBalance extends TradeKingObject {

  private String accountId;
  private double accountValue;
  private double backOfficeHouseExcess;
  private BuyingPower buyingPowerSummary;
  private double fedCall;
  private double houseCall;
  private double maintenanceExcess;
  private Cash cashSummary;
  private Securities securitiesSummary;

  public AccountBalance() {
  }

  public AccountBalance(String accountId, double accountValue, double backOfficeHouseExcess, BuyingPower buyingPowerSummary, double fedCall, double houseCall, double maintenanceExcess, Cash cashSummary, Securities securitiesSummary) {
    this.accountId = accountId;
    this.accountValue = accountValue;
    this.backOfficeHouseExcess = backOfficeHouseExcess;
    this.buyingPowerSummary = buyingPowerSummary;
    this.fedCall = fedCall;
    this.houseCall = houseCall;
    this.maintenanceExcess = maintenanceExcess;
    this.cashSummary = cashSummary;
    this.securitiesSummary = securitiesSummary;
  }

  public String getAccountId() {
    return accountId;
  }

  public double getAccountValue() {
    return accountValue;
  }

  public double getBackOfficeHouseExcess() {
    return backOfficeHouseExcess;
  }

  public BuyingPower getBuyingPowerSummary() {
    return buyingPowerSummary;
  }

  public double getFedCall() {
    return fedCall;
  }

  public double getHouseCall() {
    return houseCall;
  }

  public double getMaintenanceExcess() {
    return maintenanceExcess;
  }

  public Cash getCashSummary() {
    return cashSummary;
  }

  public Securities getSecuritiesSummary() {
    return securitiesSummary;
  }
}
