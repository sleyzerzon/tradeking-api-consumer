/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.domain.market;


import com.miserablemind.api.consumer.tradeking.api.domain.TKObject;

import java.util.Calendar;

public class StreamQuoteEvent extends TKObject {

  private double askPrice;
  private int askLatestSizeHundreds;
  private double bidPriceHundreds;
  private int bidLatestSize;
  private int bidTick;
  private Calendar dateTime;
  private String exchangeCode;
  private String conditionCode;
  private String symbol;
  private int timeStamp;

  public StreamQuoteEvent() {
  }

  public StreamQuoteEvent(double askPrice, int askLatestSizeHundreds, double bidPriceHundreds, int bidLatestSize, int bidTick, Calendar dateTime, String exchangeCode, String conditionCode, String symbol, int timeStamp) {
    this.askPrice = askPrice;
    this.askLatestSizeHundreds = askLatestSizeHundreds;
    this.bidPriceHundreds = bidPriceHundreds;
    this.bidLatestSize = bidLatestSize;
    this.bidTick = bidTick;
    this.dateTime = dateTime;
    this.exchangeCode = exchangeCode;
    this.conditionCode = conditionCode;
    this.symbol = symbol;
    this.timeStamp = timeStamp;
  }

  public double getAskPrice() {
    return askPrice;
  }

  public int getAskLatestSizeHundreds() {
    return askLatestSizeHundreds;
  }

  public double getBidPriceHundreds() {
    return bidPriceHundreds;
  }

  public int getBidLatestSize() {
    return bidLatestSize;
  }

  public int getBidTick() {
    return bidTick;
  }

  public Calendar getDateTime() {
    return dateTime;
  }

  public String getExchangeCode() {
    return exchangeCode;
  }

  public String getConditionCode() {
    return conditionCode;
  }

  public String getSymbol() {
    return symbol;
  }

  public int getTimeStamp() {
    return timeStamp;
  }
}
