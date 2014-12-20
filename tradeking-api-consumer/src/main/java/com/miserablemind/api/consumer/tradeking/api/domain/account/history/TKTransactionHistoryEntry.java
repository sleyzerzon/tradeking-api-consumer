/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TKObject;

import java.util.Date;


public class TKTransactionHistoryEntry extends TKObject {

  public static final String TRANSACTION_TYPE_ALL = "All";
  public static final String TRANSACTION_TYPE_TRADE = "Trade";
  public static final String TRANSACTION_TYPE_DIVIDEND = "Dividend";
  public static final String TRANSACTION_TYPE_BOOK_KEEPING = "Bookkeeping";

  public static final String TRANSACTION_RANGE_ALL = "all";
  public static final String TRANSACTION_RANGE_TODAY = "today";
  public static final String TRANSACTION_RANGE_CURRENT_WEEK = "current_week";
  public static final String TRANSACTION_RANGE_CURRENT_MONTH = "current_month";
  public static final String TRANSACTION_RANGE_LAST_MONTH = "last_month";

  private String activity;
  private double amount;
  private Date date;
  private String description;
  private String symbol;
  private TransactionDetails transactionDetails;

  public TKTransactionHistoryEntry() {
  }

  public TKTransactionHistoryEntry(String activity, double amount, Date date, String description, String symbol, TransactionDetails transactionDetails) {
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
}
