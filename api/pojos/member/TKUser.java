package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TKUser {

  private boolean disabled;
  private boolean resetpassword;
  private boolean resettradingpassword;

  private UserAccount account;

  @JsonProperty("userprofile")
  private UserProfile userProfile;

  public UserAccount getAccount() {
    return account;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public boolean isResetpassword() {
    return resetpassword;
  }

  public boolean isResettradingpassword() {
    return resettradingpassword;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

}
