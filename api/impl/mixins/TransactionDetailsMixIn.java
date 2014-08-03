package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.history.TransactionSecurity;

import java.util.ArrayList;
import java.util.Date;

public class TransactionDetailsMixIn extends TKObjectMixIn {

  @JsonProperty("commission")
  double commission;

  @JsonProperty("description")
  ArrayList<String> description;

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
  Date tradeDate;

  @JsonProperty("settlementdate")
  Date settlementDate;

  @JsonProperty("transactionid")
  int transactionId;

  @JsonProperty("transactiontype")
  String transacTiontype;

}
