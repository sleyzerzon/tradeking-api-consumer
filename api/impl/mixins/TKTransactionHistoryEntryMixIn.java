package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TransactionDetails;

import java.util.Date;

public class TKTransactionHistoryEntryMixIn extends TKObjectMixIn {

  @JsonProperty("activity")
  String activity;

  @JsonProperty("amount")
  double amount;

  @JsonProperty("date")
  Date date;

  @JsonProperty("desc")
  String description;

  @JsonProperty("symbol")
  String symbol;

  @JsonProperty("transaction")
  TransactionDetails transactionDetails;


}
