package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.TKUser;

@JsonRootName("response")
public class TKUserResponse extends TKObject {

  private String error;

  @JsonProperty("userdata")
  private TKUser userData;

  public TKUser getUserData() {
    return userData;
  }

  public String getError() {
    return error;
  }
}

