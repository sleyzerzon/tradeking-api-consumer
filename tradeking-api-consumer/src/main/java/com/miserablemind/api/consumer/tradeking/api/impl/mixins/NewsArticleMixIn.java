/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;


public class NewsArticleMixIn {

  @JsonProperty("id")
  private double id;

  @JsonProperty("headline")
  private String headline;

  @JsonProperty("story")
  private String story;

  @JsonProperty("date")
  private Calendar date;
}
