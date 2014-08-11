package com.miserablemind.twtbeat.domain.service.traderking.api.domain;


import java.util.HashMap;
import java.util.Map;

abstract public class TKObject {

  private Map<String, Object> extraData = new HashMap<String, Object>();

  public void add(String key, Object value) {
    extraData.put(key, value);
  }

}
