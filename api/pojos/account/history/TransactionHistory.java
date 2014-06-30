package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

import java.util.List;


public class TransactionHistory extends TKObject {

  @JsonProperty("transaction")
  private List<TKTransactionHistoryEntry> transactions;

  public List<TKTransactionHistoryEntry> getTransactions() {
    return transactions;
  }
}
