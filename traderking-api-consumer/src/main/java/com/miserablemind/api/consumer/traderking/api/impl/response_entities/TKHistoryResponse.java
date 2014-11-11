/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.traderking.api.domain.account.history.TKTransactionHistoryEntry;

import java.util.LinkedHashMap;

public class TKHistoryResponse extends TKResponse {

  private String error;

  private TKTransactionHistoryEntry[] transactionHistory;

  public String getError() {
    return error;
  }

  public TKTransactionHistoryEntry[] getTransactionHistory() {
    return transactionHistory;
  }

  @JsonSetter("transactions")
  public void setTransactionHistory(LinkedHashMap historyResponse) throws Exception {
    this.transactionHistory = (TKTransactionHistoryEntry[]) this.extractArray(TKTransactionHistoryEntry[].class, historyResponse, "transaction", null);
  }
}
