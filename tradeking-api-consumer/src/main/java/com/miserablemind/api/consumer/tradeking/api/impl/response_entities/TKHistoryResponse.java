/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TKTransaction;

import java.util.LinkedHashMap;

public class TKHistoryResponse extends TKResponse {

  private String error;

  private TKTransaction[] transactionHistory;

  public String getError() {
    return error;
  }

  public TKTransaction[] getTransactionHistory() {
    return transactionHistory;
  }

  @JsonSetter("transactions")
  public void setTransactionHistory(LinkedHashMap historyResponse) throws Exception {
    this.transactionHistory = (TKTransaction[]) this.extractArray(TKTransaction[].class, historyResponse, "transaction", null);
  }
}
