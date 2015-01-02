/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import java.util.Calendar;

/**
 * Detailed Option Quote
 */
public class OptionQuote extends Quote {

  private int contractSize;
  private short daysToExpiration;
  private String fullDescription;
  private OptionDelivery optionDelivery;
  private OptionStyle optionStyle;
  private double impliedVolatility;
  private OptionClass optionClass;
  private String openInterest;
  private double optionValueCalculation;
  private String priorDayOpenInterest;
  private double optionPremiumMultiplier;
  private OptionType optionType;
  private String optionRootSymbol;
  private double strikePrice;
  private String underlyingCUSIP;
  private String underlyingSymbol;
  private Calendar expirationDate;
  private String expirationDay;
  private String expirationMonth;
  private String expirationYear;
  private double iRho;
  private double iDelta;
  private double iTheta;
  private double iGamma;
  private double iVega;


  public OptionQuote() {
    super();
  }

  public OptionQuote(double ask, String askTime, int askLatestSize, int basis, double bid, String bidTime, int bidLatestSize, double change, ChangeSign changeSign, String changeText, double previousClose, Calendar dateLastTrade, Calendar timeLastTrade, double dollarValue, String exchangeCode, String exchangeDescription, double dayHigh, long volumeLastTrade, double lastPrice, double dayLow, String companyName, double openTradePrice, String changePercentage, ChangeSign changePercentageSign, double priorDayClose, double priorDayHigh, double priorDayLow, double priorDayOpen, Calendar dateOfPriorTradeDay, double priorDayChange, long priorDayVolume, SecurityClass securityClass, TradingSession tradingSession, String symbol, TradeCondition tradeCondition, String timeStamp, int tradeCountSinceOpen, ChangeSign tradeDirection, String trendOf10LastTicks, long cumulativeVolume, double volumeWeightedAveragePrice, double week52high, Calendar week52highDate, double week52low, Calendar week52lowDate, Calendar dateTime, String quoteConditionCode, int contractSize, short daysToExpiration, String fullDescription, OptionDelivery optionDelivery, OptionStyle optionStyle, double impliedVolatility, OptionClass optionClass, String openInterest, double optionValueCalculation, String priorDayOpenInterest, double optionPremiumMultiplier, OptionType optionType, String optionRootSymbol, double strikePrice, String underlyingCUSIP, String underlyingSymbol, Calendar expirationDate, String expirationDay, String expirationMonth, String expirationYear, double iRho, double iDelta, double iTheta, double iGamma, double iVega) {
    super(ask, askTime, askLatestSize, basis, bid, bidTime, bidLatestSize, change, changeSign, changeText, previousClose, dateLastTrade, timeLastTrade, dollarValue, exchangeCode, exchangeDescription, dayHigh, volumeLastTrade, lastPrice, dayLow, companyName, openTradePrice, changePercentage, changePercentageSign, priorDayClose, priorDayHigh, priorDayLow, priorDayOpen, dateOfPriorTradeDay, priorDayChange, priorDayVolume, securityClass, tradingSession, symbol, tradeCondition, timeStamp, tradeCountSinceOpen, tradeDirection, trendOf10LastTicks, cumulativeVolume, volumeWeightedAveragePrice, week52high, week52highDate, week52low, week52lowDate, dateTime, quoteConditionCode);
    this.contractSize = contractSize;
    this.daysToExpiration = daysToExpiration;
    this.fullDescription = fullDescription;
    this.optionDelivery = optionDelivery;
    this.optionStyle = optionStyle;
    this.impliedVolatility = impliedVolatility;
    this.optionClass = optionClass;
    this.openInterest = openInterest;
    this.optionValueCalculation = optionValueCalculation;
    this.priorDayOpenInterest = priorDayOpenInterest;
    this.optionPremiumMultiplier = optionPremiumMultiplier;
    this.optionType = optionType;
    this.optionRootSymbol = optionRootSymbol;
    this.strikePrice = strikePrice;
    this.underlyingCUSIP = underlyingCUSIP;
    this.underlyingSymbol = underlyingSymbol;
    this.expirationDate = expirationDate;
    this.expirationDay = expirationDay;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
    this.iRho = iRho;
    this.iDelta = iDelta;
    this.iTheta = iTheta;
    this.iGamma = iGamma;
    this.iVega = iVega;
  }

  /**
   * Contract size for option (usually a hundred)
   *
   * @return option contract size
   */
  public int getContractSize() {
    return contractSize;
  }

  /**
   * Days until option expiration date
   *
   * @return count of days till expiration
   */
  public short getDaysToExpiration() {
    return daysToExpiration;
  }

  /**
   * Issue description
   *
   * @return description of an option, i.e. "CALL MAR-15 $ 130.00"
   */
  public String getFullDescription() {
    return fullDescription;
  }

  /**
   * Option Settlement Designation (standard, non standard, n/a)
   *
   * @return OptionDelivery enum value
   */
  public OptionDelivery getOptionDelivery() {
    return optionDelivery;
  }

  /**
   * Option Style – European or American
   *
   * @return OptionStyle enum value
   */
  public OptionStyle getOptionStyle() {
    return optionStyle;
  }

  /**
   * Option class (Standard, Leap, Short Term)
   *
   * @return OptionClass enum value
   */
  public OptionClass getOptionClass() {
    return optionClass;
  }

  /**
   * Open interest of option contract
   *
   * @return comma delimited interest value
   */
  public String getOpenInterest() {
    return openInterest;
  }

  /**
   * Estimated Option Value – via Ju/Zhong or Black-Scholes
   *
   * @return dollar figure
   */
  public double getOptionValueCalculation() {
    return optionValueCalculation;
  }

  /**
   * Prior day's open interest
   *
   * @return comma delimited interest value
   */
  public String getPriorDayOpenInterest() {
    return priorDayOpenInterest;
  }

  /**
   * Option premium multiplier.
   * The multiplier is the numerical value used to determine the total premium for an options contract.
   * Listed stock, ETF, and index options have a multiplier of 100. Therefore, if an option is quoted at $4.00 a contract,
   * it costs $400.00 to buy that contract ($4.00 x 100). Premium sellers receive the quoted price X 100.
   *
   * @return multiplier value
   */
  public double getOptionPremiumMultiplier() {
    return optionPremiumMultiplier;
  }

  /**
   * Option type. Put or Call.
   *
   * @return OptionType enum value
   */
  public OptionType getOptionType() {
    return optionType;
  }

  /**
   * Option root symbol (stock ticker symbol for the underlying stock)
   *
   * @return root ticker symbol
   */
  public String getOptionRootSymbol() {
    return optionRootSymbol;
  }

  /**
   * Option strike price (not extended by multiplier)
   *
   * @return dollar figure
   */
  public double getStrikePrice() {
    return strikePrice;
  }

  /**
   * CUSIP of underlying stock
   *
   * @return String CUSIP
   */
  public String getUnderlyingCUSIP() {
    return underlyingCUSIP;
  }

  /**
   * An option's underlying symbol
   *
   * @return ticker symbol
   */
  public String getUnderlyingSymbol() {
    return underlyingSymbol;
  }

  /**
   * Expiration date of option in the format of (YYYYMMDD)
   *
   * @return Calendar Object
   */
  public Calendar getExpirationDate() {
    return expirationDate;
  }

  /**
   * Expiration day of option
   *
   * @return String expiration day with preceding zeros
   */
  public String getExpirationDay() {
    return expirationDay;
  }

  /**
   * Expiration month of option
   *
   * @return String expiration month with preceding zeros
   */
  public String getExpirationMonth() {
    return expirationMonth;
  }

  /**
   * Expiration year of option
   *
   * @return String expiration year
   */
  public String getExpirationYear() {
    return expirationYear;
  }

  /**
   * Implied volatility of option price based current stock price
   *
   * @return implied volatility value
   */
  public double getImpliedVolatility() {
    return impliedVolatility;
  }

  /**
   * Option risk measure of rho using implied volatility
   *
   * @return iRho value
   */
  public double getiRho() {
    return iRho;
  }

  /**
   * Option risk measure of delta using implied volatility
   *
   * @return iDelta value
   */
  public double getiDelta() {
    return iDelta;
  }

  /**
   * Option risk measure of theta using implied volatility
   *
   * @return iTheta value
   */
  public double getiTheta() {
    return iTheta;
  }

  /**
   * Option risk measure of gamma using implied volatility
   *
   * @return iGamma value
   */
  public double getiGamma() {
    return iGamma;
  }

  /**
   * Option risk measure of vega using implied volatility
   *
   * @return iVega value
   */
  public double getiVega() {
    return iVega;
  }

  /**
   * Option Type (Put or Call)
   */
  public enum OptionType {
    CALL("call"), PUT("put");
    private String value;

    OptionType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  /**
   * Option style, European or American
   */
  public enum OptionStyle {
    AMERICAN("A"), EUROPEAN("E");
    private String value;

    OptionStyle(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  /**
   * Option class, standard, short term or leap
   */
  public enum OptionClass {
    STANDARD("0"), LEAP("1"), SHORT_TERM("2");
    private String value;

    OptionClass(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  /**
   * Option delivery, Standard or Nonstandard
   */
  public enum OptionDelivery {
    STANDARD("S"), NON_STANDARD("N"), UNSPECIFIED("X");
    private String value;

    OptionDelivery(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

}

