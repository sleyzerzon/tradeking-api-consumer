package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.history.TKTransactionHistoryEntry;

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
