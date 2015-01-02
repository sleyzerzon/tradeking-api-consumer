/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;

/**
 * Time and sales quote data. This is a point at a time that shows momentum of the stock.
 */
public class TimeSalesQuote extends TradeKingObject {

  private Calendar date;
  private Calendar intervalStartTime;
  private double highPrice;
  private double lowPrice;
  private int volume;
  private double lastPrice;
  private double openTradePrice;
  private int timestamp;
  private int cumulativeVolume;

  public TimeSalesQuote() {
  }


  public TimeSalesQuote(Calendar date, Calendar intervalStartTime, double highPrice, double lowPrice, int volume, double lastPrice, double openTradePrice, int timestamp, int cumulativeVolume) {
    this.date = date;
    this.intervalStartTime = intervalStartTime;
    this.highPrice = highPrice;
    this.lowPrice = lowPrice;
    this.volume = volume;
    this.lastPrice = lastPrice;
    this.openTradePrice = openTradePrice;
    this.timestamp = timestamp;
    this.cumulativeVolume = cumulativeVolume;
  }

  /**
   * Date and time
   *
   * @return Calendar object
   */
  public Calendar getIntervalStartTime() {
    return intervalStartTime;
  }

  /**
   * High Trade Price
   *
   * @return dollar figure
   */
  public double getHighPrice() {
    return highPrice;
  }

  /**
   * Low Trade Price
   *
   * @return dollar figure
   */
  public double getLowPrice() {
    return lowPrice;
  }

  /**
   * Volume of trades
   *
   * @return volume number
   */
  public int getVolume() {
    return volume;
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
   * Open trade price
   *
   * @return dollar figure
   */
  public double getOpenTradePrice() {
    return openTradePrice;
  }

  /**
   * Timestamp
   *
   * @return integer timestamp
   */
  public int getTimestamp() {
    return timestamp;
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
   * Date
   *
   * @return Date object
   */
  public Calendar getDate() {
    return date;
  }

}
