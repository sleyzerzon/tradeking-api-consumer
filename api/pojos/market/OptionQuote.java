package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.market;

import java.util.Date;

public class OptionQuote extends Quote {

  public static final char OPTION_DELIVERY_STANDARD = 'S';
  public static final char OPTION_DELIVERY_NON_STANDARD = 'N';
  public static final char OPTION_DELIVERY_UNSPECIFIED = 'X';

  public static final char OPTION_STYLE_AMERICAN = 'A';
  public static final char OPTION_STYLE_EUROPEAN = 'E';

  public static final int OPTION_CLASS_STANDARD = 0;
  public static final int OPTION_CLASS_LEAP = 1;
  public static final int OPTION_CLASS_SHORT_TERM = 2;

  public static final String OPTION_TYPE_PUT = "put";
  public static final String OPTION_TYPE_CALL = "call";

  private int contractSize;
  private int daysToExpiration;
  private String fullDescription;
  private char optionDelivery;
  private char optionStyle;
  private int optionClass;
  private String openInterest;
  private double optionValueCalculation;
  private String priorDayOpenInterest;
  private double optionPremiumMultiplier;
  private String optionType;
  private String quoteConditionCode;
  private String optionRootSymbol;
  private double strikePrice;
  private String underlyingCusip;
  private String underlyingSymbol;
  private Date expirationDate;
  private String expirationDay;
  private String expirationMonth;
  private String expirationYear;

  public OptionQuote() {
  }

  public OptionQuote(int contractSize, int daysToExpiration, String fullDescription, char optionDelivery, char optionStyle, int optionClass, String openInterest, double optionValueCalculation, String priorDayOpenInterest, double optionPremiumMultiplier, String optionType, String quoteConditionCode, String optionRootSymbol, double strikePrice, String underlyingCusip, String underlyingSymbol, Date expirationDate, String expirationDay, String expirationMonth, String expirationYear) {
    this.contractSize = contractSize;
    this.daysToExpiration = daysToExpiration;
    this.fullDescription = fullDescription;
    this.optionDelivery = optionDelivery;
    this.optionStyle = optionStyle;
    this.optionClass = optionClass;
    this.openInterest = openInterest;
    this.optionValueCalculation = optionValueCalculation;
    this.priorDayOpenInterest = priorDayOpenInterest;
    this.optionPremiumMultiplier = optionPremiumMultiplier;
    this.optionType = optionType;
    this.quoteConditionCode = quoteConditionCode;
    this.optionRootSymbol = optionRootSymbol;
    this.strikePrice = strikePrice;
    this.underlyingCusip = underlyingCusip;
    this.underlyingSymbol = underlyingSymbol;
    this.expirationDate = expirationDate;
    this.expirationDay = expirationDay;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
  }

  public int getContractSize() {
    return contractSize;
  }

  public int getDaysToExpiration() {
    return daysToExpiration;
  }

  public String getFullDescription() {
    return fullDescription;
  }

  public char getOptionDelivery() {
    return optionDelivery;
  }

  public char getOptionStyle() {
    return optionStyle;
  }

  public int getOptionClass() {
    return optionClass;
  }

  public String getOpenInterest() {
    return openInterest;
  }

  public double getOptionValueCalculation() {
    return optionValueCalculation;
  }

  public String getPriorDayOpenInterest() {
    return priorDayOpenInterest;
  }

  public double getOptionPremiumMultiplier() {
    return optionPremiumMultiplier;
  }

  public String getOptionType() {
    return optionType;
  }

  public String getQuoteConditionCode() {
    return quoteConditionCode;
  }

  public String getOptionRootSymbol() {
    return optionRootSymbol;
  }

  public double getStrikePrice() {
    return strikePrice;
  }

  public String getUnderlyingCusip() {
    return underlyingCusip;
  }

  public String getUnderlyingSymbol() {
    return underlyingSymbol;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public String getExpirationDay() {
    return expirationDay;
  }

  public String getExpirationMonth() {
    return expirationMonth;
  }

  public String getExpirationYear() {
    return expirationYear;
  }
}

