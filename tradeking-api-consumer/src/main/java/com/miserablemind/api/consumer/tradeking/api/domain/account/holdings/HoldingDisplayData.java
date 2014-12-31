/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.holdings;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * A display data object that is included in holdings entry. It contains user friendly data about the holding, i.e.
 * dollar signs preceding dollar figures, etc.
 */
public class HoldingDisplayData extends TradeKingObject {

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

  /**
   * Account type
   *
   * @return String Account type description
   */
  public String getAccountType() {
    return accountType;
  }

  /**
   * Holding asset class type
   *
   * @return Holding asset class type String description
   */
  public String getAssetClass() {
    return assetClass;
  }

  /**
   * Holding asset change for the day
   *
   * @return String dollar figure, including preceding $
   */
  public String getChange() {
    return change;
  }

  /**
   * Holding cost basis
   *
   * @return String dollar figure, including preceding $
   */
  public String getCostBasis() {
    return costBasis;
  }

  /**
   * Holding Description, usually a company name of the instrument
   *
   * @return String holding description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Instrument last price
   *
   * @return String dollar figure, including preceding $
   */
  public String getLastPrice() {
    return lastPrice;
  }

  /**
   * Holding market value
   *
   * @return String dollar figure, including preceding $
   */
  public String getMarketValue() {
    return marketValue;
  }

  /**
   * Holding market value change
   *
   * @return String dollar figure, including preceding $
   */
  public String getMarketValueChange() {
    return marketValueChange;
  }

  /**
   * Holding quantity
   *
   * @return integer quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Instrument underlying symbol (FIXML)
   *
   * @return String symbol
   */
  public String getSymbol() {
    return symbol;
  }
}
