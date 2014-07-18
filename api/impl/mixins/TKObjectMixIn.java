package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonAnySetter;

abstract public class TKObjectMixIn {

  @JsonAnySetter
  protected void add(String key, Object value) {
  }

}
