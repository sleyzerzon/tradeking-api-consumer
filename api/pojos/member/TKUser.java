package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member;

public class TKUser {

  private boolean disabled;
  private boolean resetPassword;
  private boolean resetTradingPassword;
  private UserAccount account;
  private UserProfile userProfile;

  public UserAccount getAccount() {
    return account;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public boolean isResetPassword() {
    return resetPassword;
  }

  public boolean isResetTradingPassword() {
    return resetTradingPassword;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

}
