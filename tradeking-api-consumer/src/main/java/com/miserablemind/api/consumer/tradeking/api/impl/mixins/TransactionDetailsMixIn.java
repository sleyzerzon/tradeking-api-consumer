/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TransactionSecurity;

import java.util.Calendar;

public class TransactionDetailsMixIn extends TradeKingKObjectMixIn {

  @JsonProperty("commission")
  double commission;

  @JsonProperty("fee")
  double fee;

  @JsonProperty("price")
  double price;

  @JsonProperty("quantity")
  double quantity;

  @JsonProperty("source")
  String source;

  @JsonProperty("side")
  int side;

  @JsonProperty("accounttype")
  int accountType;

  @JsonProperty("secfee")
  double SECFee;

  @JsonProperty("security")
  TransactionSecurity transactionSecurity;

  @JsonProperty("tradedate")
  Calendar tradeDate;

  @JsonProperty("settlementdate")
  Calendar settlementDate;

  @JsonProperty("transactionid")
  int transactionId;

  @JsonProperty("transactiontype")
  String transactionType;

  @JsonSetter("description")
  void setDescription(Object description) {
  }


}
