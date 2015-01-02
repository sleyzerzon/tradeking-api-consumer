/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;

/**
 * Abstract quote class that holds all the data that stocks and options have in common.
 * It is extended by {@link OptionQuote} and {@link StockQuote} for type specific data
 */
abstract public class Quote extends TradeKingObject {

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
  private Calendar dateLastTrade;
  private Calendar timeLastTrade;
  private double dollarValue;
  private String exchangeCode;
  private String exchangeDescription;
  private double dayHigh;
  private long volumeLastTrade;
  private double lastPrice;
  private double dayLow;
  private String companyName;
  private double openTradePrice;
  private String changePercentage;
  private ChangeSign changePercentageSign;
  private double priorDayClose;
  private double priorDayHigh;
  private double priorDayLow;
  private double priorDayOpen;
  private Calendar dateOfPriorTradeDay;
  private double priorDayChange;
  private long priorDayVolume;
  private SecurityClass securityClass;
  private TradingSession tradingSession;
  private String symbol;
  private TradeCondition tradeCondition;
  private String timeStamp;
  private int tradeCountSinceOpen;
  private ChangeSign tradeDirection;
  private String trendOf10LastTicks;
  private long cumulativeVolume;
  private double volumeWeightedAveragePrice;
  private double week52high;
  private Calendar week52highDate;
  private double week52low;
  private Calendar week52lowDate;
  private Calendar dateTime;
  private String quoteConditionCode;

  public Quote() {
  }

  public Quote(double ask, String askTime, int askLatestSize, int basis, double bid, String bidTime, int bidLatestSize, double change, ChangeSign changeSign, String changeText, double previousClose, Calendar dateLastTrade, Calendar timeLastTrade, double dollarValue, String exchangeCode, String exchangeDescription, double dayHigh, long volumeLastTrade, double lastPrice, double dayLow, String companyName, double openTradePrice, String changePercentage, ChangeSign changePercentageSign, double priorDayClose, double priorDayHigh, double priorDayLow, double priorDayOpen, Calendar dateOfPriorTradeDay, double priorDayChange, long priorDayVolume, SecurityClass securityClass, TradingSession tradingSession, String symbol, TradeCondition tradeCondition, String timeStamp, int tradeCountSinceOpen, ChangeSign tradeDirection, String trendOf10LastTicks, long cumulativeVolume, double volumeWeightedAveragePrice, double week52high, Calendar week52highDate, double week52low, Calendar week52lowDate, Calendar dateTime, String quoteConditionCode) {
    this.ask = ask;
    this.askTime = askTime;
    this.askLatestSize = askLatestSize;
    this.basis = basis;
    this.bid = bid;
    this.bidTime = bidTime;
    this.bidLatestSize = bidLatestSize;
    this.change = change;
    this.changeSign = changeSign;
    this.changeText = changeText;
    this.previousClose = previousClose;
    this.dateLastTrade = dateLastTrade;
    this.timeLastTrade = timeLastTrade;
    this.dollarValue = dollarValue;
    this.exchangeCode = exchangeCode;
    this.exchangeDescription = exchangeDescription;
    this.dayHigh = dayHigh;
    this.volumeLastTrade = volumeLastTrade;
    this.lastPrice = lastPrice;
    this.dayLow = dayLow;
    this.companyName = companyName;
    this.openTradePrice = openTradePrice;
    this.changePercentage = changePercentage;
    this.changePercentageSign = changePercentageSign;
    this.priorDayClose = priorDayClose;
    this.priorDayHigh = priorDayHigh;
    this.priorDayLow = priorDayLow;
    this.priorDayOpen = priorDayOpen;
    this.dateOfPriorTradeDay = dateOfPriorTradeDay;
    this.priorDayChange = priorDayChange;
    this.priorDayVolume = priorDayVolume;
    this.securityClass = securityClass;
    this.tradingSession = tradingSession;
    this.symbol = symbol;
    this.tradeCondition = tradeCondition;
    this.timeStamp = timeStamp;
    this.tradeCountSinceOpen = tradeCountSinceOpen;
    this.tradeDirection = tradeDirection;
    this.trendOf10LastTicks = trendOf10LastTicks;
    this.cumulativeVolume = cumulativeVolume;
    this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    this.week52high = week52high;
    this.week52highDate = week52highDate;
    this.week52low = week52low;
    this.week52lowDate = week52lowDate;
    this.dateTime = dateTime;
    this.quoteConditionCode = quoteConditionCode;
  }

  /**
   * Ask price
   *
   * @return dollar figure
   */
  public double getAsk() {
    return ask;
  }

  /**
   * String time hh:mm of Time of latest ask
   *
   * @return String hh:mm time
   */
  public String getAskTime() {
    return askTime;
  }

  /**
   * Size of latest ask (in 100's)
   *
   * @return integer size of latest ask in hundreds
   */
  public int getAskLatestSizeHundreds() {
    return askLatestSize;
  }

  /**
   * Reported precision (quotation decimal places)
   *
   * @return int count of decimal digits
   */
  public int getBasis() {
    return basis;
  }

  /**
   * Bid price
   *
   * @return dollar figure
   */
  public double getBid() {
    return bid;
  }

  /**
   * String time hh:mm of Time of latest bid
   *
   * @return String hh:mm time
   */
  public String getBidTime() {
    return bidTime;
  }

  /**
   * Size of latest bid (in 100's)
   *
   * @return integer size of latest ask in hundreds
   */
  public int getBidLatestSizeHundreds() {
    return bidLatestSize;
  }

  /**
   * Change since prior day close (cl)
   *
   * @return dollar figure
   */
  public double getChange() {
    return change;
  }

  /**
   * Change sign  as even, up, down
   *
   * @return ChangeSign enum value
   */
  public ChangeSign getChangeSign() {
    return changeSign;
  }

  /**
   * Change in Text Format, does not have currency symbol, or anything special, just all the trailing decimals
   *
   * @return text change value with all the trailing decimals
   */
  public String getChangeText() {
    return changeText;
  }

  /**
   * Prior day close
   *
   * @return dollar figure
   */
  public double getPreviousClose() {
    return previousClose;
  }

  /**
   * Trade date of last trade
   *
   * @return date
   */
  public Calendar getDateLastTrade() {
    return dateLastTrade;
  }

  /**
   * Trade Date of Prior Last
   *
   * @return date
   */
  public Calendar getTimeLastTrade() {
    return timeLastTrade;
  }

  /**
   * Total dollar value of shares traded today
   *
   * @return dollar figure in standard form, i.e. 3.58616648E8
   */
  public double getDollarValue() {
    return dollarValue;
  }

  /**
   * Exchange Code of quote provider
   *
   * @return exchange code
   */
  public String getExchangeCode() {
    return exchangeCode;
  }

  /**
   * Exchange Description of quote provider
   *
   * @return string exchange description
   */
  public String getExchangeDescription() {
    return exchangeDescription;
  }

  /**
   * High Trade Price for the trading day
   *
   * @return dollar figure
   */
  public double getDayHigh() {
    return dayHigh;
  }

  /**
   * Volume of last trade
   *
   * @return int volume of last trade
   */
  public long getVolumeLastTrade() {
    return volumeLastTrade;
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
   * Low Trade Price for the trading day
   *
   * @return dollar figure
   */
  public double getDayLow() {
    return dayLow;
  }

  /**
   * Company name
   *
   * @return Company name
   */
  public String getCompanyName() {
    return companyName;
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
   * Percentage change from prior day close
   *
   * @return String percentage with percentage symbol in it
   */
  public String getChangePercentage() {
    return changePercentage;
  }

  /**
   * Percentage change sign from a prior day close
   *
   * @return enum change sign value
   */
  public ChangeSign getChangePercentageSign() {
    return changePercentageSign;
  }

  /**
   * Prior day close
   *
   * @return dollar figure
   */
  public double getPriorDayClose() {
    return priorDayClose;
  }

  /**
   * Prior day high value
   *
   * @return dollar figure
   */
  public double getPriorDayHigh() {
    return priorDayHigh;
  }

  /**
   * Prior day low value
   *
   * @return dollar figure
   */
  public double getPriorDayLow() {
    return priorDayLow;
  }

  /**
   * Prior day open
   *
   * @return dollar figure
   */
  public double getPriorDayOpen() {
    return priorDayOpen;
  }

  /**
   * Trade Date of Prior Last
   *
   * @return Calendar Object
   */
  public Calendar getDateOfPriorTradeDay() {
    return dateOfPriorTradeDay;
  }

  /**
   * Prior day change
   *
   * @return dollar figure, for a negative has a preceding minus
   */
  public double getPriorDayChange() {
    return priorDayChange;
  }

  /**
   * Prior day total volume
   *
   * @return long volume
   */
  public long getPriorDayVolume() {
    return priorDayVolume;
  }

  /**
   * Security class (stock or option)
   *
   * @return SecurityClass enum value
   */
  public SecurityClass getSecurityClass() {
    return securityClass;
  }

  /**
   * Trading session as pre, regular, post
   *
   * @return TradingSession enum value
   */
  public TradingSession getTradingSession() {
    return tradingSession;
  }

  /**
   * Symbol from data provider
   *
   * @return symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Trade condition code – halted or resumed
   *
   * @return TradeCondition enum value
   */
  public TradeCondition getTradeCondition() {
    return tradeCondition;
  }

  /**
   * Unix Timestamp
   *
   * @return String timestamp value
   */
  public String getTimeStamp() {
    return timeStamp;
  }

  /**
   * Number of trades since market open
   *
   * @return int count
   */
  public int getTradeCountSinceOpen() {
    return tradeCountSinceOpen;
  }

  /**
   * Tick direction from prior trade – (e,u,d) even, up, down)
   *
   * @return ChangeSign enum value
   */
  public ChangeSign getTradeDirection() {
    return tradeDirection;
  }

  /**
   * Trend based on 10 prior ticks (e,u,d) even, up, down
   *
   * @return string of ten consecutive letters
   */
  public String getTrendOf10LastTicks() {
    return trendOf10LastTicks;
  }

  /**
   * Cumulative volume
   *
   * @return long volume
   */
  public long getCumulativeVolume() {
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
   * 52 week high
   *
   * @return dollar figure
   */
  public double getWeek52high() {
    return week52high;
  }

  //todo: 70s

  /**
   * 52 week high date
   *
   * @return calendar object
   */
  public Calendar getWeek52highDate() {
    return week52highDate;
  }

  /**
   * 52 week low
   *
   * @return Calendar object
   */
  public double getWeek52low() {
    return week52low;
  }

  //todo: 70s

  /**
   * 52 week low date
   *
   * @return Calendar object
   */
  public Calendar getWeek52lowDate() {
    return week52lowDate;
  }

  /**
   * Security class used in quotes, to indicate if the quote is for option or for stock
   */
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

  /**
   * Indicates the session state of the time when quote was reveived
   */
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
