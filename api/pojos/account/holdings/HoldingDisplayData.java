package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class HoldingDisplayData extends TKObject {

  @JsonProperty("accounttype")
  private String accountType;

  @JsonProperty("assetclass")
  private String assetClass;

  private String change;

  @JsonProperty("costbasis")
  private String costBasis;

  @JsonProperty("desc")
  private String description;

  @JsonProperty("lastprice")
  private String lastPrice;

  @JsonProperty("marketvalue")
  private String marketValue;

  @JsonProperty("marketvaluechange")
  private String marketValueChange;

  @JsonProperty("qty")
  private int quantity;

  private String symbol;

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
