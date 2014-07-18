package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccountMixIn extends TKObjectMixIn {

  @JsonProperty("account")
  private String account;

  @JsonProperty("fundtrading")
  private boolean fundTrading;

  @JsonProperty("ira")
  private boolean ira;

  @JsonProperty("margintrading")
  private boolean marginTrading;

  @JsonProperty("nickname")
  private String nickName;

  @JsonProperty("optionlevel")
  private int optionLevel;

  @JsonProperty("shared")
  private boolean shared;

  @JsonProperty("stocktrading")
  private boolean stockTrading;

}
