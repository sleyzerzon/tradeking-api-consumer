package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;

public class TKOptionExpirationsResponse extends TKResponse {

  private String error;

  private Calendar[] dates;

  @JsonSetter("expirationdates")
  public void setDates(LinkedHashMap datesResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    Object pricesContainer = datesResponse.get("date");

    String jsonArray = mapper.writeValueAsString(pricesContainer);

    if (pricesContainer.getClass() == ArrayList.class)
      this.dates = mapper.readValue(jsonArray, Calendar[].class);
    else this.dates = new Calendar[]{mapper.readValue(jsonArray, Calendar.class)};

  }

  public String getError() {
    return error;
  }

  public Calendar[] getDates() {
    return dates;
  }
}
