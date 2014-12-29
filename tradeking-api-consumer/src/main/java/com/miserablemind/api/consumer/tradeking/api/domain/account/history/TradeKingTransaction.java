/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Date;


public class TradeKingTransaction extends TradeKingObject {

  private String activity;
  private double amount;
  private Date date;
  private String description;
  private String symbol;
  private TransactionDetails transactionDetails;

  public TradeKingTransaction() {
  }

  public TradeKingTransaction(String activity, double amount, Date date, String description, String symbol, TransactionDetails transactionDetails) {
    this.activity = activity;
    this.amount = amount;
    this.date = date;
    this.description = description;
    this.symbol = symbol;
    this.transactionDetails = transactionDetails;
  }

  public String getActivity() {
    return activity;
  }

  public double getAmount() {
    return amount;
  }

  public Date getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public String getSymbol() {
    return symbol;
  }

  public TransactionDetails getTransactionDetails() {
    return transactionDetails;
  }

  public enum Type {
    ALL("all"), TRADE("trade"), DIVIDEND("dividend"), BOOK_KEEPING("bookkeeping");
    private String value;

    Type(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

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
