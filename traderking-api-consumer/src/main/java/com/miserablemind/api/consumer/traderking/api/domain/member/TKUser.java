/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.domain.member;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

public class TKUser extends TKObject {

  private boolean disabled;
  private boolean resetPassword;
  private boolean resetTradingPassword;
  private UserAccount account;
  private UserProfile userProfile;

  public TKUser() {
  }

  public TKUser(boolean disabled, boolean resetPassword, boolean resetTradingPassword, UserAccount account, UserProfile userProfile) {
    this.disabled = disabled;
    this.resetPassword = resetPassword;
    this.resetTradingPassword = resetTradingPassword;
    this.account = account;
    this.userProfile = userProfile;
  }

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
