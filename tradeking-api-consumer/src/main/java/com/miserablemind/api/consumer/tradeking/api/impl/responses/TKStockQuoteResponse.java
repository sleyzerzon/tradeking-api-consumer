/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.responses;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.market.StockQuote;

import java.util.Map;

public class TKStockQuoteResponse extends TKResponse {

    private String error;

    private StockQuote[] quotes;

    @JsonSetter("quotes")
    public void setQuote(Map quotesResponse) throws Exception {
        this.quotes = (StockQuote[]) this.extractArray(StockQuote[].class, quotesResponse, "quote");
    }

    public String getError() {
        return error;
    }

    public StockQuote[] getQuotes() {
        return quotes;
    }
}
