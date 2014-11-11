package com.miserablemind.api.consumer.traderking.api.domain.market;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

import java.util.Date;

abstract public class Quote extends TKObject {

  private double ask;
  private String askTime;
  private int askLatestSize;
  private int basis;
  private double bid;
  private String bidTime;
  private int bidLatestSize;
  private double change;
  private ChangeSign changeSign;
  private String changeText;
  private double previousClose;
  private Date dateLastTrade;
  private Date timeLastTrade;
  private double volumeToday;
  private String exchangeCode;
  private String exchangeDescription;
  private double dayHigh;
  private int volumeLastTrade;
  private double lastPrice;
  private double dayLow;
  private String companyName;
  private double openTradePrice;
  private String changePercentage;
  private String changePercentageSign;
  private double priorDayClose;
  private double priorDayHigh;
  private double priorDayLow;
  private double priorDayOpen;
  private Date dateOfPriorTradeDay;
  private double priorDayChange;
  private int priodDayVolume;
  private SecurityClass securityClass;
  private TradingSession tradingSession;
  private String symbol;
  private TradeCondition tradeCondition;
  private Date timeStamp;
  private int tradeCountSinceOpen;
  private char tradeDirection;
  private String trendOf10LastTicks;
  private int cumulativeVolume;
  private double volumeWeightedAveragePrice;
  private double week52high;
  private Date week52highDate;
  private double week52low;
  private Date week52lowDate;
  private Date dateTime;
  private String quoteConditionCode;


  public double getAsk() {
    return ask;
  }

  public String getAskTime() {
    return askTime;
  }

  public int getAskLatestSize() {
    return askLatestSize;
  }

  public int getBasis() {
    return basis;
  }

  public double getBid() {
    return bid;
  }

  public String getBidTime() {
    return bidTime;
  }

  public int getBidLatestSize() {
    return bidLatestSize;
  }

  public double getChange() {
    return change;
  }

  public ChangeSign getChangeSign() {
    return changeSign;
  }

  public String getChangeText() {
    return changeText;
  }

  public double getPreviousClose() {
    return previousClose;
  }

  public Date getDateLastTrade() {
    return dateLastTrade;
  }

  public Date getTimeLastTrade() {
    return timeLastTrade;
  }

  public double getVolumeToday() {
    return volumeToday;
  }

  public String getExchangeCode() {
    return exchangeCode;
  }

  public String getExchangeDescription() {
    return exchangeDescription;
  }

  public double getDayHigh() {
    return dayHigh;
  }

  public int getVolumeLastTrade() {
    return volumeLastTrade;
  }

  public double getLastPrice() {
    return lastPrice;
  }

  public double getDayLow() {
    return dayLow;
  }

  public String getCompanyName() {
    return companyName;
  }

  public double getOpenTradePrice() {
    return openTradePrice;
  }

  public String getChangePercentage() {
    return changePercentage;
  }

  public String getChangePercentageSign() {
    return changePercentageSign;
  }

  public double getPriorDayClose() {
    return priorDayClose;
  }

  public double getPriorDayHigh() {
    return priorDayHigh;
  }

  public double getPriorDayLow() {
    return priorDayLow;
  }

  public double getPriorDayOpen() {
    return priorDayOpen;
  }

  public Date getDateOfPriorTradeDay() {
    return dateOfPriorTradeDay;
  }

  public double getPriorDayChange() {
    return priorDayChange;
  }

  public int getPriodDayVolume() {
    return priodDayVolume;
  }

  public SecurityClass getSecurityClass() {
    return securityClass;
  }

  public TradingSession getTradingSession() {
    return tradingSession;
  }

  public String getSymbol() {
    return symbol;
  }

  public TradeCondition getTradeCondition() {
    return tradeCondition;
  }

  //todo 70s date
  public Date getTimeStamp() {
    return timeStamp;
  }

  public int getTradeCountSinceOpen() {
    return tradeCountSinceOpen;
  }

  public char getTradeDirection() {
    return tradeDirection;
  }

  public String getTrendOf10LastTicks() {
    return trendOf10LastTicks;
  }

  public int getCumulativeVolume() {
    return cumulativeVolume;
  }

  public double getVolumeWeightedAveragePrice() {
    return volumeWeightedAveragePrice;
  }

  public double getWeek52high() {
    return week52high;
  }

  //todo: 70s
  public Date getWeek52highDate() {
    return week52highDate;
  }

  public double getWeek52low() {
    return week52low;
  }

  //todo: 70s
  public Date getWeek52lowDate() {
    return week52lowDate;
  }

  public enum SecurityClass {
    STOCK("0"), OPTION("1");
    private String value;

    SecurityClass(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  public enum TradeCondition {
    HALTED("H"), RESUMED("R");
    private String value;

    TradeCondition(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  public enum TradingSession {
    MARKET("regular"), PRE_MARKET("pre"), POST_MARKET("post");
    private String value;

    TradingSession(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

}
