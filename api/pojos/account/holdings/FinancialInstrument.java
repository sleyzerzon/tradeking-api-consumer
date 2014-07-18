package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;


import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class FinancialInstrument extends TKObject {

  private String cusip;
  private String description;
  private double factor;
  private String securityType;
  private String symbol;

  public FinancialInstrument() {
  }

  public FinancialInstrument(String cusip, String description, double factor, String securityType, String symbol) {
    this.cusip = cusip;
    this.description = description;
    this.factor = factor;
    this.securityType = securityType;
    this.symbol = symbol;
  }

  public String getCusip() {
    return cusip;
  }

  public String getDescription() {
    return description;
  }

  public double getFactor() {
    return factor;
  }

  /**
   * Instrument security type (FIXML)
   *
   * @return security type
   */
  public String getSecurityType() {
    return securityType;
  }

  public String getSymbol() {
    return symbol;
  }
}
