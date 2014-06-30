package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

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

  @JsonProperty("desc")
  private String description;

  private String symbol;

  @JsonProperty("transaction")
  private TransactionDetails transactionDetails;

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
