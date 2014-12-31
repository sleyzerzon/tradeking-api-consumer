/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Date;


/**
 * A class that holds all the data about a transaction that happened in the past
 */
public class TradeKingTransaction extends TradeKingObject {

  private Type activityType;
  private double amount;
  private Date date;
  private String description;
  private String symbol;
  private TransactionDetails transactionDetails;

  public TradeKingTransaction() {
  }

  public TradeKingTransaction(Type activity, double amount, Date date, String description, String symbol, TransactionDetails transactionDetails) {
    this.activityType = activity;
    this.amount = amount;
    this.date = date;
    this.description = description;
    this.symbol = symbol;
    this.transactionDetails = transactionDetails;
  }

  /**
   * Type of the transaction
   *
   * @return enum of activity type
   */
  public Type getActivityType() {
    return activityType;
  }

  /**
   * Transaction amount. Negative if bought something, positive if sold.
   *
   * @return dollar figure
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Date of the transaction. Seems to have the date accurate, all the hours are midnight for New York (-05:00)
   *
   * @return transaction date
   */
  public Date getDate() {
    return date;
  }

  /**
   * Display friendly description. Company name and brief transaction description (for some transaction types)
   *
   * @return String brief transaction description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Symbol of the instrument
   *
   * @return String symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * More details about transaction itself
   *
   * @return TransactionDetails Object
   */
  public TransactionDetails getTransactionDetails() {
    return transactionDetails;
  }

  /**
   * Transaction Type
   */
  public enum Type {
    ALL("All"), TRADE("Trade"), DIVIDEND("Dividend"), BOOK_KEEPING("Bookkeeping"), INTEREST("Interest");
    private String value;

    Type(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  /**
   * When pulling transactions, these are the filters to use
   */
  public enum Range {
    ALL("all"), TODAY("today"), CURRENT_WEEK("current_week"), CURRENT_MONTH("current_month"), LAST_MONTH("last_month");
    private String value;

    Range(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

}
