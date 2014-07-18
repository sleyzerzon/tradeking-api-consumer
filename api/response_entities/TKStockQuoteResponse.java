package com.miserablemind.twtbeat.domain.service.traderking.api.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.market.StockQuote;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@JsonRootName("response")
public class TKStockQuoteResponse extends TKObject {

  @JsonProperty("error")
  private String error;

  private StockQuote[] quotes;


  @JsonSetter("quotes")
  public void setQuote(LinkedHashMap quotesResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new TraderKingModule());

    Object quotesContainer = quotesResponse.get("quote");
    String jsonArray = mapper.writeValueAsString(quotesContainer);

    //API returns list if multiple quotes objects, but a quote object if only one. Standardize here.
    if (quotesContainer.getClass() == ArrayList.class) this.quotes = mapper.readValue(jsonArray, StockQuote[].class);
    else this.quotes = new StockQuote[]{mapper.readValue(jsonArray, StockQuote.class)};

  }

  public String getError() {
    return error;
  }

  public StockQuote[] getQuotes() {
    return quotes;
  }
}
