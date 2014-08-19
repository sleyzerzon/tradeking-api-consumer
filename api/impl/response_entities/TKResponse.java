package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.HashMap;
import java.util.Map;

@JsonRootName("response")
abstract public class TKResponse {

  private Map<String, Object> extraData = new HashMap<String, Object>();

  @JsonAnySetter
  public void add(String key, Object value) {
    extraData.put(key, value);
  }

}
