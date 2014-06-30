package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class FinancialInstrument extends TKObject {

  private String cusip;

  @JsonProperty("desc")
  private String description;

  private double factor;

  @JsonProperty("sectyp")
  private String securityType;

  @JsonProperty("sym")
  private String symbol;

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
