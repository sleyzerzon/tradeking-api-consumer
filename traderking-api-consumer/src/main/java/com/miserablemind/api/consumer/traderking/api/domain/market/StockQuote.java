package com.miserablemind.api.consumer.traderking.api.domain.market;

import java.util.Date;

public class StockQuote extends Quote {

  //todo: round all these values to the cent

  private double averageDailyPrice100;
  private double averageDailyPrice200;
  private double averageDailyPrice50;
  private double averageDailyPrice21;
  private double averageDailyPrice30;
  private double averageDailyPrice90;
  private double beta;
  private int tickDirectionSinceLastBid;
  private String cusip;
  private double lastDividend;
  private Date exDividendDate;
  private char dividendFrequency;
  private Date lastDividendPayDate;
  private double earningsPerShare;
  private double indicatedAnnualDividend;
  private int hasOptions;
  private double priorAverageDailyPrice100;
  private double priorAverageDailyPrice200;
  private double priorAverageDailyPrice50;
  private double bookValuePrice;
  private String sharesOutstanding;
  private double oneYearVolatility;
  private double dividendYield;
  private double priceEarning;
  private int sessionVolume;


  public StockQuote() {
  }

  public StockQuote(double averageDailyPrice100, double averageDailyPrice200, double averageDailyPrice50, double averageDailyPrice21, double averageDailyPrice30, double averageDailyPrice90, double beta, int tickDirectionSinceLastBid, String cusip, double lastDividend, Date exDividendDate, char dividendFrequency, Date lastDividendPayDate, double earningsPerShare, double indicatedAnnualDividend, int hasOptions, double priorAverageDailyPrice100, double priorAverageDailyPrice200, double priorAverageDailyPrice50, double bookValuePrice, String sharesOutstanding, double oneYearVolatility, double dividendYield, double priceEarning, int sessionVolume) {
    this.averageDailyPrice100 = averageDailyPrice100;
    this.averageDailyPrice200 = averageDailyPrice200;
    this.averageDailyPrice50 = averageDailyPrice50;
    this.averageDailyPrice21 = averageDailyPrice21;
    this.averageDailyPrice30 = averageDailyPrice30;
    this.averageDailyPrice90 = averageDailyPrice90;
    this.beta = beta;
    this.tickDirectionSinceLastBid = tickDirectionSinceLastBid;
    this.cusip = cusip;
    this.lastDividend = lastDividend;
    this.exDividendDate = exDividendDate;
    this.dividendFrequency = dividendFrequency;
    this.lastDividendPayDate = lastDividendPayDate;
    this.earningsPerShare = earningsPerShare;
    this.indicatedAnnualDividend = indicatedAnnualDividend;
    this.hasOptions = hasOptions;
    this.priorAverageDailyPrice100 = priorAverageDailyPrice100;
    this.priorAverageDailyPrice200 = priorAverageDailyPrice200;
    this.priorAverageDailyPrice50 = priorAverageDailyPrice50;
    this.bookValuePrice = bookValuePrice;
    this.sharesOutstanding = sharesOutstanding;
    this.oneYearVolatility = oneYearVolatility;
    this.dividendYield = dividendYield;
    this.priceEarning = priceEarning;
    this.sessionVolume = sessionVolume;
  }

  public double getAverageDailyPrice100() {
    return averageDailyPrice100;
  }

  public double getAverageDailyPrice200() {
    return averageDailyPrice200;
  }

  public double getAverageDailyPrice50() {
    return averageDailyPrice50;
  }

  public double getAverageDailyPrice21() {
    return averageDailyPrice21;
  }

  public double getAverageDailyPrice30() {
    return averageDailyPrice30;
  }

  public double getAverageDailyPrice90() {
    return averageDailyPrice90;
  }

  public double getBeta() {
    return beta;
  }

  public int getTickDirectionSinceLastBid() {
    return tickDirectionSinceLastBid;
  }

  public String getCusip() {
    return cusip;
  }

  public double getLastDividend() {
    return lastDividend;
  }

  //todo 70s here (20140610)
  public Date getExDividendDate() {
    return exDividendDate;
  }

  public char getDividendFrequency() {
    return dividendFrequency;
  }


  //todo 70s (20140610)
  public Date getLastDividendPayDate() {
    return lastDividendPayDate;
  }

  public double getEarningsPerShare() {
    return earningsPerShare;
  }

  public double getIndicatedAnnualDividend() {
    return indicatedAnnualDividend;
  }

  public boolean isHasOptions() {
    return (hasOptions == 1);
  }

  public double getPriorAverageDailyPrice100() {
    return priorAverageDailyPrice100;
  }

  public double getPriorAverageDailyPrice200() {
    return priorAverageDailyPrice200;
  }

  public double getPriorAverageDailyPrice50() {
    return priorAverageDailyPrice50;
  }

  public double getBookValuePrice() {
    return bookValuePrice;
  }

  public String getSharesOutstanding() {
    return sharesOutstanding;
  }

  public double getOneYearVolatility() {
    return oneYearVolatility;
  }

  public double getDividendYield() {
    return dividendYield;
  }

  public double getPriceEarning() {
    return priceEarning;
  }

  public int getSessionVolume() {
    return sessionVolume;
  }
}
