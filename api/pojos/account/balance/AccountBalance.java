package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;


public class AccountBalance extends TKObject {

  @JsonProperty("account")
  private String accountId;

  @JsonProperty("accountvalue")
  private double accountValue;

  @JsonProperty("backofficehouseexcess")
  private double backOfficeHouseExcess;

  @JsonProperty("buyingpower")
  private BuyingPower buyingPowerSummary;

  @JsonProperty("fedcall")
  private double fedCall;

  @JsonProperty("housecall")
  private double houseCall;

  @JsonProperty("maintenanceexcess")
  private double maintainanceAccess;

  @JsonProperty("money")
  private Cash cashSummary;

  @JsonProperty("securities")
  private Securities securitiesSummary;


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

  public double getMaintainanceAccess() {
    return maintainanceAccess;
  }

  public Cash getCashSummary() {
    return cashSummary;
  }

  public Securities getSecuritiesSummary() {
    return securitiesSummary;
  }
}
