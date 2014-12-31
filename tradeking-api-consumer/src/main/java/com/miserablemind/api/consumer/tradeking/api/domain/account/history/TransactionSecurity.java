/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * Brief details about transaction security itself
 */
public class TransactionSecurity extends TradeKingObject {

  private String CUSIP;
  private String id;
  private String securityType;
  private String symbol;

  public TransactionSecurity() {
  }

  public TransactionSecurity(String CUSIP, String id, String securityType, String symbol) {
    this.CUSIP = CUSIP;
    this.id = id;
    this.securityType = securityType;
    this.symbol = symbol;
  }

  /**
   * A CUSIP is a nine-character alphanumeric code that identifies a North American financial security for the purposes
   * of facilitating clearing and settlement of trades. (Wikipedia)
   *
   * @return String CUSIP
   */
  public String getCUSIP() {
    return CUSIP;
  }

  /**
   * Transaction Id. Seems to be the same as CUSIP without the last digit.
   *
   * @return String transaction ID
   */
  public String getId() {
    return id;
  }


  /**
   * Security Type
   *
   * @return String Security Type
   */
  public String getSecurityType() {
    return securityType;
  }

  /**
   * Instrument Symbol
   *
   * @return String symbol
   */
  public String getSymbol() {
    return symbol;
  }
}
