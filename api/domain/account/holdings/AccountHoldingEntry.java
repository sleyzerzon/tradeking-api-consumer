package com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.holdings;

import com.miserablemind.twtbeat.domain.service.traderking.api.domain.TKObject;

public class AccountHoldingEntry extends TKObject {

  public enum HoldingType {
    CACHE(1), LONG(2), SHORT(5);
    private final Integer value;

    HoldingType(int i) {
      this.value = i;
    }

    @Override
    public String toString() {
      return this.value.toString();
    }
  }

  private HoldingType holdingType;
  private double costBasis;
  private HoldingDisplayData displayData;
  private double gainLoss;
  private FinancialInstrument instrument;
  private double marketValue;
  private double marketValueChange;
  private double price;
  private double purchasePrice;
  private double quantity;
  private HoldingsQuote holdingsQuote;
  private double SODCostBasis;
  private String underlying;

  public AccountHoldingEntry() {
  }

  public AccountHoldingEntry(HoldingType holdingType, double costBasis, HoldingDisplayData displayData, double gainLoss, FinancialInstrument instrument, double marketValue, double marketValueChange, double price, double purchasePrice, double quantity, HoldingsQuote holdingsQuote, double SODCostBasis, String underlying) {
    this.holdingType = holdingType;
    this.costBasis = costBasis;
    this.displayData = displayData;
    this.gainLoss = gainLoss;
    this.instrument = instrument;
    this.marketValue = marketValue;
    this.marketValueChange = marketValueChange;
    this.price = price;
    this.purchasePrice = purchasePrice;
    this.quantity = quantity;
    this.holdingsQuote = holdingsQuote;
    this.SODCostBasis = SODCostBasis;
    this.underlying = underlying;
  }

  public HoldingType getHoldingType() {
    return holdingType;
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

  public HoldingsQuote getQuote() {
    return holdingsQuote;
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
