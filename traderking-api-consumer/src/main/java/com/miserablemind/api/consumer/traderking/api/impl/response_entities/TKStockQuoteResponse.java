package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.traderking.api.domain.market.StockQuote;

import java.util.LinkedHashMap;

public class TKStockQuoteResponse extends TKResponse {

  private String error;

  private StockQuote[] quotes;

  @JsonSetter("quotes")
  public void setQuote(LinkedHashMap quotesResponse) throws Exception {
    this.quotes = (StockQuote[]) this.extractArray(StockQuote[].class, quotesResponse, "quote", null);
  }

  public String getError() {
    return error;
  }

  public StockQuote[] getQuotes() {
    return quotes;
  }
}
