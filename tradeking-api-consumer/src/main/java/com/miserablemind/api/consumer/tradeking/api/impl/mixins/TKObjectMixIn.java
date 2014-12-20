/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonAnySetter;

abstract public class TKObjectMixIn {

  @JsonAnySetter
  protected void add(String key, Object value) {
  }

}
