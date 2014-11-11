package com.miserablemind.api.consumer.traderking.api.domain.market;

import java.util.Date;

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
  private String underlyingCusip;
  private String underlyingSymbol;
  private Date expirationDate;
  private String expirationDay;
  private String expirationMonth;
  private String expirationYear;
  private double iRho;
  private double iDelta;
  private double iTheta;
  private double iGamma;
  private double iVega;


  public OptionQuote() {
  }

  public OptionQuote(int contractSize, short daysToExpiration, String fullDescription, OptionDelivery optionDelivery, OptionStyle optionStyle, double impliedVolatility, OptionClass optionClass, String openInterest, double optionValueCalculation, String priorDayOpenInterest, double optionPremiumMultiplier, OptionType optionType, String optionRootSymbol, double strikePrice, String underlyingCusip, String underlyingSymbol, Date expirationDate, String expirationDay, String expirationMonth, String expirationYear, double iRho, double iDelta, double iTheta, double iGamma, double iVega) {
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
    this.underlyingCusip = underlyingCusip;
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

  public int getContractSize() {
    return contractSize;
  }

  public short getDaysToExpiration() {
    return daysToExpiration;
  }

  public String getFullDescription() {
    return fullDescription;
  }

  public OptionDelivery getOptionDelivery() {
    return optionDelivery;
  }

  public OptionStyle getOptionStyle() {
    return optionStyle;
  }

  public OptionClass getOptionClass() {
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

  public OptionType getOptionType() {
    return optionType;
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

  public double getImpliedVolatility() {
    return impliedVolatility;
  }

  public double getiRho() {
    return iRho;
  }

  public double getiDelta() {
    return iDelta;
  }

  public double getiTheta() {
    return iTheta;
  }

  public double getiGamma() {
    return iGamma;
  }

  public double getiVega() {
    return iVega;
  }

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

