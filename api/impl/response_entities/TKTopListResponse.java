package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.TopListEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TKTopListResponse extends TKResponse {

  private String error;

  private TopListEntry[] topList;

  @JsonSetter("quotes")
  public void setQuotes(LinkedHashMap topListResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new TraderKingModule());
    mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
    mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

    Object topListEntry = topListResponse.get("quote");
    String jsonArray = mapper.writeValueAsString(topListEntry);

    if (topListEntry.getClass() == ArrayList.class)
      this.topList = mapper.readValue(jsonArray, TopListEntry[].class);
    else this.topList = new TopListEntry[]{mapper.readValue(jsonArray, TopListEntry.class)};
  }


  public String getError() {
    return error;
  }

  public TopListEntry[] getTopList() {
    return this.topList;
  }
}
