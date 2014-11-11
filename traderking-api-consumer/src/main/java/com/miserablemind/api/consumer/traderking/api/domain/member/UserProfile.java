/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.domain.member;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

public class UserProfile extends TKObject {

  private String UUID;
  private String accountSummaryDashboardCollapsed;
  private String firstName;
  private String lasName;
  private boolean hasMewMessage;
  private boolean realTimeStockQuote;
  private String emailAddress;
  private String FDICPaper;
  private boolean isGainsKeeper;
  private boolean isTradingPasswordUsed;
  private String FDICAgreement;

  public UserProfile() {

  }

  public UserProfile(String UUID, String accountSummaryDashboardCollapsed, String firstName, String lasName, boolean hasMewMessage, boolean realTimeStockQuote, String emailAddress, String FDICPaper, boolean isGainsKeeper, boolean isTradingPasswordUsed, String FDICAgreement) {
    this.UUID = UUID;
    this.accountSummaryDashboardCollapsed = accountSummaryDashboardCollapsed;
    this.firstName = firstName;
    this.lasName = lasName;
    this.hasMewMessage = hasMewMessage;
    this.realTimeStockQuote = realTimeStockQuote;
    this.emailAddress = emailAddress;
    this.FDICPaper = FDICPaper;
    this.isGainsKeeper = isGainsKeeper;
    this.isTradingPasswordUsed = isTradingPasswordUsed;
    this.FDICAgreement = FDICAgreement;
  }

  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public String getAccountSummaryDashboardCollapsed() {
    return accountSummaryDashboardCollapsed;
  }

  public void setAccountSummaryDashboardCollapsed(String accountSummaryDashboardCollapsed) {
    this.accountSummaryDashboardCollapsed = accountSummaryDashboardCollapsed;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLasName() {
    return lasName;
  }

  public void setLasName(String lasName) {
    this.lasName = lasName;
  }

  public boolean isHasMewMessage() {
    return hasMewMessage;
  }

  public void setHasMewMessage(boolean hasMewMessage) {
    this.hasMewMessage = hasMewMessage;
  }

  public boolean isRealTimeStockQuote() {
    return realTimeStockQuote;
  }

  public void setRealTimeStockQuote(boolean realTimeStockQuote) {
    this.realTimeStockQuote = realTimeStockQuote;
  }

  public String getFDICPaper() {
    return FDICPaper;
  }

  public void setFDICPaper(String FDICPaper) {
    this.FDICPaper = FDICPaper;
  }

  public boolean isGainsKeeper() {
    return isGainsKeeper;
  }

  public void setGainsKeeper(boolean isGainsKeeper) {
    this.isGainsKeeper = isGainsKeeper;
  }

  public boolean isTradingPasswordUsed() {
    return isTradingPasswordUsed;
  }

  public void setTradingPasswordUsed(boolean isTradingPasswordUsed) {
    this.isTradingPasswordUsed = isTradingPasswordUsed;
  }

  public String getFDICAgreement() {
    return FDICAgreement;
  }

  public void setFDICAgreement(String FDICAgreement) {
    this.FDICAgreement = FDICAgreement;
  }


  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

}
