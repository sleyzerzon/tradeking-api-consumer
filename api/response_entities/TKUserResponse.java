package com.miserablemind.twtbeat.domain.service.traderking.api.response_entities;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.TKUser;

@JsonRootName("response")
public class TKUserResponse extends TKObject {

  private String error;

  private TKUser userdata;


  public TKUser getUserdata() {
    return userdata;
  }

  public String getError() {
    return error;
  }
}

