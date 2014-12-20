/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.domain.watchlist;

import com.miserablemind.api.consumer.tradeking.api.domain.TKObject;

public class WatchlistItem extends TKObject {

  private double costBasis;
  private double quantity;
  private String symbol;

  public WatchlistItem() {
  }

  public WatchlistItem(double costBasis, double quantity, String symbol) {
    this.costBasis = costBasis;
    this.quantity = quantity;
    this.symbol = symbol;
  }

  public double getCostBasis() {
    return costBasis;
  }

  public double getQuantity() {
    return quantity;
  }

  public String getSymbol() {
    return symbol;
  }
}
