package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.traderking.api.domain.market.TopListEntry;

import java.util.LinkedHashMap;

public class TKTopListResponse extends TKResponse {

  private String error;

  private TopListEntry[] topList;

  @JsonSetter("quotes")
  public void setQuotes(LinkedHashMap topListResponse) throws Exception {
    this.topList = (TopListEntry[]) this.extractArray(TopListEntry[].class, topListResponse, "quote", null);
  }


  public String getError() {
    return error;
  }

  public TopListEntry[] getTopList() {
    return this.topList;
  }
}
