package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history;

import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty("accounttype")
  private int accounTtype;

  @JsonProperty("secfee")
  private double SECFee;

  @JsonProperty("security")
  private TransactionSecurity transactionSecurity;

  @JsonProperty("tradedate")
  private Date tradeDate;

  @JsonProperty("settlementdate")
  private Date settlementDate;

  @JsonProperty("transactionid")
  private int transactionId;

  @JsonProperty("transactiontype")
  private String transacTiontype;

  public double getCommission() {
    return commission;
  }

  public ArrayList<String> getDescription() {
    return description;
  }

  @JsonSetter("description")
  public void setDescription(Object description) {
    if (description.getClass() == String.class) {
      ArrayList<String> decriptionHolder = new ArrayList<String>();
      decriptionHolder.add((String) description);
      this.description = decriptionHolder;
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

  public int getAccounTtype() {
    return accounTtype;
  }
}
