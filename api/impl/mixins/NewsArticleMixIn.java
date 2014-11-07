package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

/**
 * Miserable Mind
 * http://www.butter.miserablemind.com
 * GNU GENERAL PUBLIC LICENSE Version 2
 */
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
