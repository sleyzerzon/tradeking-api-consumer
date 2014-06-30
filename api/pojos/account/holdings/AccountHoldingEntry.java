package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class AccountHoldingEntry extends TKObject {

  public static final int ACCOUNT_TYPE_CACHE = 1;
  public static final int ACCOUNT_TYPE_MARGIN_LONG = 2;
  public static final int ACCOUNT_TYPE_MARGIN_SHORT = 5;

  @JsonProperty("accounttype")
  private int accounType;

  @JsonProperty("costbasis")
  private double costBasis;

  @JsonProperty("displaydata")
  private HoldingDisplayData displayData;

  @JsonProperty("gainloss")
  private double gainLoss;

  private FinancialInstrument instrument;

  @JsonProperty("marketvalue")
  private double marketValue;

  @JsonProperty("marketvaluechange")
  private double marketValueChange;

  private double price;

  @JsonProperty("purchaseprice")
  private double purchasePrice;

  @JsonProperty("qty")
  private double quantity;

  private Quote quote;

  @JsonProperty("sodcostbasis")
  private double SODCostBasis;

  private String underlying;

  public int getAccounType() {
    return accounType;
  }

  public double getCostBasis() {
    return costBasis;
  }

  public HoldingDisplayData getDisplayData() {
    return displayData;
  }

  public double getGainLoss() {
    return gainLoss;
  }

  public FinancialInstrument getInstrument() {
    return instrument;
  }

  public double getMarketValue() {
    return marketValue;
  }

  public double getMarketValueChange() {
    return marketValueChange;
  }

  public double getPrice() {
    return price;
  }

  public double getPurchasePrice() {
    return purchasePrice;
  }

  public double getQuantity() {
    return quantity;
  }

  public Quote getQuote() {
    return quote;
  }

  /**
   * Start of Day Cost Basis
   *
   * @return start of day cost basis in dollars
   */
  public double getSODCostBasis() {
    return SODCostBasis;
  }

  public String getUnderlying() {
    return underlying;
  }
}
