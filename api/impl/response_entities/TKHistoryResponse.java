package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.history.TKTransactionHistoryEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;

import java.util.ArrayList;
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

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new TraderKingModule());

    Object historyContainer = historyResponse.get("transaction");
    String jsonArray = mapper.writeValueAsString(historyContainer);

    //API returns list if multiple history objects, but a history object if only one. Standardize here.
    if (historyContainer.getClass() == ArrayList.class)
      this.transactionHistory = mapper.readValue(jsonArray, TKTransactionHistoryEntry[].class);
    else
      this.transactionHistory = new TKTransactionHistoryEntry[]{mapper.readValue(jsonArray, TKTransactionHistoryEntry.class)};

  }
}
