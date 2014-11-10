package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.OptionQuote;

import java.util.LinkedHashMap;

public class TKOptionQuoteResponse extends TKResponse {

  private String error;

  private OptionQuote[] quotes;

  @JsonSetter("quotes")
  public void setQuote(LinkedHashMap quotesResponse) throws Exception {
    this.quotes = (OptionQuote[]) this.extractArray(OptionQuote[].class, quotesResponse, "quote", null);
  }

  public String getError() {
    return error;
  }

  public OptionQuote[] getQuotes() {
    return quotes;
  }

}
