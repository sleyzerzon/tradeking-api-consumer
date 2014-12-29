/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;


public class TopListEntry extends TradeKingObject {

  public enum ListType {

    LOSERS_DOLLARS("toplosers"), LOSERS_PERCENTAGE("toppctlosers"), VOLUME("topvolume"), ACTIVE("topactive"), GAINERS_DOLLARS("topgainers"),
    GAINERS_PERCENTAGE("toppctgainers"), GAINERS_ACTIVE_DOLLARS("topactivegainersbydollarvalue");

    private final String name;

    ListType(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return this.name;
    }
  }

  private double change;
  private ChangeSign changeDirection;
  private double lastTradePrice;
  private String companyName;
  private String percentageChange;
  private double priorDayClosePrice;
  private int rankInTheList;
  private String ticker;
  private int volume;

  public TopListEntry() {
  }

  public TopListEntry(double change, ChangeSign changeDirection, double lastTradePrice, String companyName, String percentageChange, double priorDayClosePrice, int rankInTheList, String ticker, int volume) {
    this.change = change;
    this.changeDirection = changeDirection;
    this.lastTradePrice = lastTradePrice;
    this.companyName = companyName;
    this.percentageChange = percentageChange;
    this.priorDayClosePrice = priorDayClosePrice;
    this.rankInTheList = rankInTheList;
    this.ticker = ticker;
    this.volume = volume;
  }

  public double getChange() {
    return change;
  }

  public ChangeSign getChangeDirection() {
    return changeDirection;
  }

  public double getLastTradePrice() {
    return lastTradePrice;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getPercentageChange() {
    return percentageChange;
  }

  public double getPriorDayClosePrice() {
    return priorDayClosePrice;
  }

  public int getRankInTheList() {
    return rankInTheList;
  }

  public String getTicker() {
    return ticker;
  }

  public int getVolume() {
    return volume;
  }
}
