/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.domain.member;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

public class UserAccount extends TKObject {

  private String account;
  private boolean fundTrading;
  private boolean ira;
  private boolean marginTrading;
  private String nickName;
  private int optionLevel;
  private boolean shared;
  private boolean stockTrading;

  public UserAccount() {
  }

  public UserAccount(String account, boolean fundTrading, boolean ira, boolean marginTrading, String nickName, int optionLevel, boolean shared, boolean stockTrading) {
    this.account = account;
    this.fundTrading = fundTrading;
    this.ira = ira;
    this.marginTrading = marginTrading;
    this.nickName = nickName;
    this.optionLevel = optionLevel;
    this.shared = shared;
    this.stockTrading = stockTrading;
  }

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
