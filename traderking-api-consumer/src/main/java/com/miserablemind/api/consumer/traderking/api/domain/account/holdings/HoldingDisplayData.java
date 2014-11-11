package com.miserablemind.api.consumer.traderking.api.domain.account.holdings;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

public class HoldingDisplayData extends TKObject {

  private String accountType;
  private String assetClass;
  private String change;
  private String costBasis;
  private String description;
  private String lastPrice;
  private String marketValue;
  private String marketValueChange;
  private int quantity;
  private String symbol;

  public HoldingDisplayData() {
  }

  public HoldingDisplayData(String accountType, String assetClass, String change, String costBasis, String description, String lastPrice, String marketValue, String marketValueChange, int quantity, String symbol) {
    this.accountType = accountType;
    this.assetClass = assetClass;
    this.change = change;
    this.costBasis = costBasis;
    this.description = description;
    this.lastPrice = lastPrice;
    this.marketValue = marketValue;
    this.marketValueChange = marketValueChange;
    this.quantity = quantity;
    this.symbol = symbol;
  }

  public String getAccountType() {
    return accountType;
  }

  public String getAssetClass() {
    return assetClass;
  }

  public String getChange() {
    return change;
  }

  public String getCostBasis() {
    return costBasis;
  }

  public String getDescription() {
    return description;
  }

  public String getLastPrice() {
    return lastPrice;
  }

  public String getMarketValue() {
    return marketValue;
  }

  public String getMarketValueChange() {
    return marketValueChange;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getSymbol() {
    return symbol;
  }
}
