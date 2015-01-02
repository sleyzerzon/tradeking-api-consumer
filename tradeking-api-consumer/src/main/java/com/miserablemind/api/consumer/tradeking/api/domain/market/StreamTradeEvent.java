/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.domain.market;


import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;

/**
 * TK API allows to subscribe to streams, one of them is Trades
 * This object represents  trade event that happens in the market.
 */
public class StreamTradeEvent extends TradeKingObject {

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

  /**
   * Symbol from data provider
   *
   * @return string instrument symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * eExchange code
   *
   * @return String exchange code description
   */
  public String getExchangeCode() {
    return exchangeCode;
  }

  /**
   * Last trade price
   *
   * @return dollar figure
   */
  public double getLastPrice() {
    return lastPrice;
  }

  /**
   * Volume
   *
   * @return volume number
   */
  public int getVolume() {
    return volume;
  }

  /**
   * Cumulative volume
   *
   * @return volume number
   */
  public int getCumulativeVolume() {
    return cumulativeVolume;
  }

  /**
   * Volume weighted average price
   *
   * @return dollar figure
   */
  public double getVolumeWeightedAveragePrice() {
    return volumeWeightedAveragePrice;
  }

  /**
   * Date and time
   *
   * @return Calendar object
   */
  public Calendar getDateTime() {
    return dateTime;
  }

  /**
   * Timestamp
   *
   * @return integer timestamp
   */
  public int getTimeStamp() {
    return timeStamp;
  }

  /**
   * Trade condition code – (H) halted or (R) resumed. (docs)
   * However, returns integers for now that are not documented
   *
   * @return String trade condition
   */
  public String getTradeCondition() {
    return tradeCondition;
  }
}
