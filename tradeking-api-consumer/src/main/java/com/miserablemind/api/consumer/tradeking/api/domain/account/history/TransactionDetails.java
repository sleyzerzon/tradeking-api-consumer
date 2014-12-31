/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Details about transaction including price, fees, quantities
 */
public class TransactionDetails extends TradeKingObject {

  private double commission;
  private String description;
  private double fee;
  private double price;
  private double quantity;
  private String source;
  private int side;
  private int accountType;
  private double SECFee;
  private TransactionSecurity transactionSecurity;
  private Date tradeDate;
  private Date settlementDate;
  private int transactionId;
  private String transactionType;

  public TransactionDetails() {
  }

  public TransactionDetails(double commission, String description, double fee, double price, double quantity, String source, int side, int accountType, double SECFee, TransactionSecurity transactionSecurity, Date tradeDate, Date settlementDate, int transactionId, String transactionType) {
    this.commission = commission;
    this.description = description;
    this.fee = fee;
    this.price = price;
    this.quantity = quantity;
    this.source = source;
    this.side = side;
    this.accountType = accountType;
    this.SECFee = SECFee;
    this.transactionSecurity = transactionSecurity;
    this.tradeDate = tradeDate;
    this.settlementDate = settlementDate;
    this.transactionId = transactionId;
    this.transactionType = transactionType;
  }

  /**
   * Commission paid for transaction
   *
   * @return dollar figure
   */
  public double getCommission() {
    return commission;
  }

  /**
   * Description of transaction
   *
   * @return String Description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Transaction fee. This is not the commission for trade.
   *
   * @return dollar figure
   */
  public double getFee() {
    return fee;
  }

  /**
   * Price of the unit of security
   *
   * @return dollar figure
   */
  public double getPrice() {
    return price;
  }

  /**
   * Quantity of the securities in transaction.
   *
   * @return quantity of securities. Negative means sell, positive means buy.
   */
  public double getQuantity() {
    return quantity;
  }

  /**
   * Source of transaction i.e. XCH as exchange, DIV as dividends etc...
   *
   * @return String description of source
   */
  public String getSource() {
    return source;
  }

  /**
   * SEC fee for transaction
   *
   * @return dollar figure
   */
  public double getSECFee() {
    return SECFee;
  }

  /**
   * Transaction Security
   *
   * @return Object with Security details
   */
  public TransactionSecurity getTransactionSecurity() {
    return transactionSecurity;
  }

  /**
   * Date when trade happened
   *
   * @return Date object. Accurate to the day, which means hours are midnight -05:00
   */
  public Date getTradeDate() {
    return tradeDate;
  }

  /**
   * Date transaction was settled.
   *
   * @return Date object. Accurate to the day, which means hours are midnight -05:00
   */
  public Date getSettlementDate() {
    return settlementDate;
  }

  /**
   * Transaction Id (for some reason always seems to be 10)
   *
   * @return integer transaction Id
   */
  public int getTransactionId() {
    return transactionId;
  }

  /**
   * Transaction type. Null for trades, description of transaction for different types
   *
   * @return transaction type description
   */
  public String getTransactionType() {
    return transactionType;
  }

  /**
   * Side. This is not documented, but seems like:
   * Buy Transactions: Side 1,
   * Sell - Side 2
   * Others - Side 0
   *
   * @return integer side id
   */
  public int getSide() {
    return side;
  }

  /**
   * Account TYPE. Unfortunately this is not documented in api docs.
   *
   * @return integer account type
   */
  public int getAccountType() {
    return accountType;
  }

  /**
   * This method is needed as TK sometimes returns description as String, sometimes as Array
   *
   * @param description description fed by Jackson
   */
  public void setDescription(Object description) {
    if (description.getClass() == String.class) {
      this.description = (String) description;
    } else {
      ArrayList<String> descriptionList = (ArrayList<String>) description;
      StringBuilder stringDescription = new StringBuilder();
      for (String descriptionPart : descriptionList) {
        stringDescription.append(descriptionPart).append(" ");
      }
      this.description = stringDescription.toString();
    }
  }
}
