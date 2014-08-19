package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.OptionQuote;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TKOptionQuoteResponse extends TKResponse {

  @JsonProperty("error")
  private String error;

  private OptionQuote[] quotes;


  @JsonSetter("quotes")
  public void setQuote(LinkedHashMap quotesResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new TraderKingModule());
    mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
    mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

    Object quotesContainer = quotesResponse.get("quote");
    String jsonArray = mapper.writeValueAsString(quotesContainer);

    //API returns list if multiple quotes objects, but a quote object if only one. Standardize here.
    if (quotesContainer.getClass() == ArrayList.class) this.quotes = mapper.readValue(jsonArray, OptionQuote[].class);
    else this.quotes = new OptionQuote[]{mapper.readValue(jsonArray, OptionQuote.class)};

  }

  public String getError() {
    return error;
  }

  public OptionQuote[] getQuotes() {
    return quotes;
  }

}
