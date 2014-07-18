package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class AccountHoldingEntry extends TKObject {

  public static final int ACCOUNT_TYPE_CACHE = 1;
  public static final int ACCOUNT_TYPE_MARGIN_LONG = 2;
  public static final int ACCOUNT_TYPE_MARGIN_SHORT = 5;

  private int accountType;
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

  public AccountHoldingEntry(int accountType, double costBasis, HoldingDisplayData displayData, double gainLoss, FinancialInstrument instrument, double marketValue, double marketValueChange, double price, double purchasePrice, double quantity, HoldingsQuote holdingsQuote, double SODCostBasis, String underlying) {
    this.accountType = accountType;
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

  public int getAccountType() {
    return accountType;
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
