package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.UserAccount;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.UserProfile;

public class TKUserMixIn extends TKObjectMixIn {

  @JsonProperty("disabled")
  boolean disabled;

  @JsonProperty("resetpassword")
  boolean resetPassword;

  @JsonProperty("resettradingpassword")
  boolean resetTradingPassword;

  @JsonProperty("account")
  UserAccount account;

  @JsonProperty("userprofile")
  UserProfile userProfile;


}
