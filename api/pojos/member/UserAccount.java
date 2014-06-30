package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member;


import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class UserAccount extends TKObject {

  private String account;
  private boolean fundtrading;
  private boolean ira;
  private boolean margintrading;
  private String nickname;
  private int optionlevel;
  private boolean shared;
  private boolean stocktrading;

  public String getAccount() {
    return account;
  }

  public boolean isFundtrading() {
    return fundtrading;
  }

  public boolean isIra() {
    return ira;
  }

  public boolean isMargintrading() {
    return margintrading;
  }

  public String getNickname() {
    return nickname;
  }

  public int getOptionlevel() {
    return optionlevel;
  }

  public boolean isShared() {
    return shared;
  }

  public boolean isStocktrading() {
    return stocktrading;
  }
}
