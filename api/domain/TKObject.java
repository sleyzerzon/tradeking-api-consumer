package com.miserablemind.twtbeat.domain.service.traderking.api.domain;


import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

abstract public class TKObject {

  private Map<String, Object> extraData = new HashMap<String, Object>();

  @JsonAnySetter
  protected void add(String key, Object value) {
    extraData.put(key, value);
  }

}
