/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.api.consumer.tradeking.api.domain.market.MarketStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;

public class TKMarketStatusResponse extends TKResponse {

  private String error;

  @JsonIgnore
  private MarketStatus marketStatus;

  @JsonIgnore
  private String currentStatus;

  @JsonIgnore
  private String nextStatus;

  @JsonIgnore
  private String changeAt;

  @JsonIgnore
  private Calendar date;

  @JsonProperty("message")
  private String message;

  @JsonProperty("unixtime")
  private int unixTime;

  /**
   * Deserializer does not understand the milliseconds, need to do it manually here
   *
   * @param dateResponse a String date from Json
   * @throws Exception
   */
  @JsonSetter("date")
  public void setDate(String dateResponse) throws Exception {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
    Date date = dateFormat.parse(dateResponse);
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    this.date = calendar;

  }

  /**
   * This needs an explicit setter to unwrap the values from inside of "status" object
   *
   * @param statusResponse value from deserializer, in this case object "status" as a HashMap
   * @throws Exception
   */
  @JsonSetter("status")
  public void setAccounts(LinkedHashMap statusResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();

    this.currentStatus = (String) statusResponse.get("current");
    this.nextStatus = (String) statusResponse.get("next");
    this.changeAt = (String) statusResponse.get("change_at");

  }

  public String getError() {
    return error;
  }

  public MarketStatus getMarketStatus() {
    if (null == this.marketStatus) {
      this.marketStatus = new MarketStatus(this.date
              , MarketStatus.MarketCondition.fromString(this.currentStatus)
              , MarketStatus.MarketCondition.fromString(this.nextStatus)
              , this.changeAt
              , this.message
              , this.unixTime);
    }

    return this.marketStatus;
  }
}
