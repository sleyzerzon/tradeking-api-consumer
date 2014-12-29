/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

public class TransactionSecurity extends TradeKingObject {

  private String cusip;
  private String id;
  private String securityType;
  private String symbol;

  public TransactionSecurity() {
  }

  public TransactionSecurity(String cusip, String id, String securityType, String symbol) {
    this.cusip = cusip;
    this.id = id;
    this.securityType = securityType;
    this.symbol = symbol;
  }

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
