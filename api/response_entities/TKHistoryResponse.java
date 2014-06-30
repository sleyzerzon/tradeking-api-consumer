package com.miserablemind.twtbeat.domain.service.traderking.api.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TransactionHistory;

@JsonRootName("response")
public class TKHistoryResponse extends TKObject {

  private String error;

  @JsonProperty("transactions")
  private TransactionHistory transactionHistory;

  public String getError() {
    return error;
  }

  public TransactionHistory getTransactionHistory() {
    return transactionHistory;
  }


}
