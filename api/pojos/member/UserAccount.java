package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member;


import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class UserAccount extends TKObject {

  private String account;
  private boolean fundTrading;
  private boolean ira;
  private boolean marginTrading;
  private String nickName;
  private int optionLevel;
  private boolean shared;
  private boolean stockTrading;

  public String getAccount() {
    return account;
  }

  public boolean isFundTrading() {
    return fundTrading;
  }

  public boolean isIra() {
    return ira;
  }

  public boolean isMarginTrading() {
    return marginTrading;
  }

  public String getNickName() {
    return nickName;
  }

  public int getOptionLevel() {
    return optionLevel;
  }

  public boolean isShared() {
    return shared;
  }

  public boolean isStockTrading() {
    return stockTrading;
  }
}
