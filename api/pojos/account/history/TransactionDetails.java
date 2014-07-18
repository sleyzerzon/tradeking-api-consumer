package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

import java.util.ArrayList;
import java.util.Date;


public class TransactionDetails extends TKObject {

  private double commission;
  private ArrayList<String> description;
  private double fee;
  private double price;
  private double quantity;
  private String source;
  private int side;
  private int accountType;
  private double SECFee;
  private TransactionSecurity transactionSecurity;
  private Date tradeDate;
  private Date settlementDate;
  private int transactionId;
  private String transacTiontype;

  public TransactionDetails() {
  }

  public TransactionDetails(double commission, ArrayList<String> description, double fee, double price, double quantity, String source, int side, int accountType, double SECFee, TransactionSecurity transactionSecurity, Date tradeDate, Date settlementDate, int transactionId, String transacTiontype) {
    this.commission = commission;
    this.description = description;
    this.fee = fee;
    this.price = price;
    this.quantity = quantity;
    this.source = source;
    this.side = side;
    this.accountType = accountType;
    this.SECFee = SECFee;
    this.transactionSecurity = transactionSecurity;
    this.tradeDate = tradeDate;
    this.settlementDate = settlementDate;
    this.transactionId = transactionId;
    this.transacTiontype = transacTiontype;
  }

  public double getCommission() {
    return commission;
  }

  public ArrayList<String> getDescription() {
    return description;
  }

  @JsonSetter("description")
  public void setDescription(Object description) {
    if (description.getClass() == String.class) {
      ArrayList<String> descriptionHolder = new ArrayList<String>();
      descriptionHolder.add((String) description);
      this.description = descriptionHolder;
    } else {
      this.description = (ArrayList<String>) description;
    }
  }

  public double getFee() {
    return fee;
  }

  public double getPrice() {
    return price;
  }

  public double getQuantity() {
    return quantity;
  }

  public String getSource() {
    return source;
  }

  public double getSECFee() {
    return SECFee;
  }

  public TransactionSecurity getTransactionSecurity() {
    return transactionSecurity;
  }

  public Date getTradeDate() {
    return tradeDate;
  }

  public Date getSettlementDate() {
    return settlementDate;
  }

  public int getTransactionId() {
    return transactionId;
  }

  public String getTransacTiontype() {
    return transacTiontype;
  }

  public int getSide() {
    return side;
  }

  public int getAccountType() {
    return accountType;
  }
}