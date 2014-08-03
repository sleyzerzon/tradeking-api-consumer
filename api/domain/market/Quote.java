package com.miserablemind.twtbeat.domain.service.traderking.api.domain.market;

import com.miserablemind.twtbeat.domain.service.traderking.api.domain.TKObject;

import java.util.Date;

abstract public class Quote extends TKObject {

  public static final char CHANGE_SIGN_UP = 'u';
  public static final char CHANGE_SIGN_DOWN = 'd';
  public static final char CHANGE_SIGN_EQUAL = 'e';

  public static final int SECURITY_CLASS_STOCK = 0;
  public static final int SECURITY_CLASS_OPTION = 1;

  public static final char TRADE_CONDITION_HALTED = 'H';
  public static final char TRADE_CONDITION_RESUMED = 'R';

  public static final String TRADING_SESSION_REGULAR = "regular";
  public static final String TRADING_SESSION_PRE = "pre";
  public static final String TRADING_SESSION_POST = "post";

  private double ask;
  private String askTime;
  private int askLatestSize;
  private int basis;
  private double bid;
  private String bidTime;
  private int bidLatestSize;
  private double change;
  private char changeSign;
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
  private int securityClass;
  private String tradingSession;
  private String symbol;
  private char tradeCondition;
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

  public char getChangeSign() {
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

  public int getSecurityClass() {
    return securityClass;
  }

  public String getTradingSession() {
    return tradingSession;
  }

  public String getSymbol() {
    return symbol;
  }

  public char getTradeCondition() {
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
}
