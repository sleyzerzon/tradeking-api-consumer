/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TransactionDetails;

import java.util.Date;

public class TKTransactionMixIn extends TKObjectMixIn {

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
