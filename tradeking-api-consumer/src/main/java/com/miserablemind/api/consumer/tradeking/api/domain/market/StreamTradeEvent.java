/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.domain.market;


import com.miserablemind.api.consumer.tradeking.api.domain.TKObject;

import java.util.Calendar;

public class StreamTradeEvent extends TKObject {

  private String symbol;
  private String exchangeCode;
  private double lastPrice;
  private int volume;
  private int cumulativeVolume;
  private double volumeWeightedAveragePrice;
  private Calendar dateTime;
  private int timeStamp;
  private String tradeCondition;

  public StreamTradeEvent() {
  }

  public StreamTradeEvent(String symbol, String exchangeCode, double lastPrice, int volume, int cumulativeVolume, double volumeWeightedAveragePrice, Calendar dateTime, int timeStamp, String tradeCondition) {
    this.symbol = symbol;
    this.exchangeCode = exchangeCode;
    this.lastPrice = lastPrice;
    this.volume = volume;
    this.cumulativeVolume = cumulativeVolume;
    this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    this.dateTime = dateTime;
    this.timeStamp = timeStamp;
    this.tradeCondition = tradeCondition;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getExchangeCode() {
    return exchangeCode;
  }

  public double getLastPrice() {
    return lastPrice;
  }

  public int getVolume() {
    return volume;
  }

  public int getCumulativeVolume() {
    return cumulativeVolume;
  }

  public double getVolumeWeightedAveragePrice() {
    return volumeWeightedAveragePrice;
  }

  public Calendar getDateTime() {
    return dateTime;
  }

  public int getTimeStamp() {
    return timeStamp;
  }

  public String getTradeCondition() {
    return tradeCondition;
  }
}
