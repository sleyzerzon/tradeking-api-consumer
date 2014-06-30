package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;


public class TransactionSecurity extends TKObject {

  private String cusip;

  private String id;

  @JsonProperty("sectyp")
  private String securityType;

  @JsonProperty("sym")
  private String symbol;


  public String getCusip() {
    return cusip;
  }

  public String getId() {
    return id;
  }

  public String getSecurityType() {
    return securityType;
  }

  public String getSymbol() {
    return symbol;
  }
}
