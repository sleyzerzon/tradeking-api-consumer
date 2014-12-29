/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MarketStatus extends TradeKingObject {

  private Calendar date;
  private MarketCondition currentStatus;
  private MarketCondition nextStatus;
  private String nextMarketStatusTime;
  private String statusMessage;
  private int serverUnixTimeStamp;

  public enum MarketCondition {

    PRE_OPEN("pre"), OPEN("open"), AFTER_MARKET("after"), CLOSED("closed");

    private String name;

    private static final Map<String, MarketCondition> map = new HashMap<String, MarketCondition>();

    static {
      for (MarketCondition type : MarketCondition.values()) {
        map.put(type.name, type);
      }
    }

    MarketCondition(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public static MarketCondition fromString(String name) {
      if (map.containsKey(name)) {
        return map.get(name);
      }
      throw new NoSuchElementException(name + "not found");
    }

  }

  public MarketStatus() {

  }

  public MarketStatus(Calendar date, MarketCondition currentStatus, MarketCondition nextStatus, String nextMarketStatusTime, String statusMessage, int serverUnixTimeStamp) {
    this.date = date;
    this.currentStatus = currentStatus;
    this.nextStatus = nextStatus;
    this.nextMarketStatusTime = nextMarketStatusTime;
    this.statusMessage = statusMessage;
    this.serverUnixTimeStamp = serverUnixTimeStamp;
  }

  public Calendar getDate() {
    return date;
  }

  public MarketCondition getCurrentStatus() {
    return currentStatus;
  }

  public MarketCondition getNextStatus() {
    return nextStatus;
  }

  public String getNextMarketStatusTime() {
    return nextMarketStatusTime;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public int getServerUnixTimeStamp() {
    return serverUnixTimeStamp;
  }
}
