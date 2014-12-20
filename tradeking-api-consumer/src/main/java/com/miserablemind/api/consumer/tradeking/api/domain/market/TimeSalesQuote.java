/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TKObject;

import java.util.Calendar;

public class TimeSalesQuote extends TKObject {

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

  public Calendar getIntervalStartTime() {
    return intervalStartTime;
  }

  public double getHighPrice() {
    return highPrice;
  }

  public double getLowPrice() {
    return lowPrice;
  }

  public int getVolume() {
    return volume;
  }

  public double getLastPrice() {
    return lastPrice;
  }

  public double getOpenTradePrice() {
    return openTradePrice;
  }

  public int getTimestamp() {
    return timestamp;
  }

  public int getCumulativeVolume() {
    return cumulativeVolume;
  }

  public Calendar getDate() {
    return date;
  }

  public enum Interval {
    MINUTES_1("1min"), MINUTES_5("5min"), TICK("tick");
    private final String name;

    Interval(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return this.name;
    }


  }
}
