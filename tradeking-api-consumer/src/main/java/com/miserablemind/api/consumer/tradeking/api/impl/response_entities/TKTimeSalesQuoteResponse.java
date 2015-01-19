/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.market.TimeSalesQuote;

import java.util.LinkedHashMap;

public class TKTimeSalesQuoteResponse extends TKResponse {

    private String error;

    private TimeSalesQuote[] quotes;

    @JsonSetter("quotes")
    public void setQuote(LinkedHashMap quotesResponse) throws Exception {
        this.quotes = (TimeSalesQuote[]) this.extractArray(TimeSalesQuote[].class, quotesResponse, "quote", null);
    }

    public String getError() {
        return error;
    }

    public TimeSalesQuote[] getQuotes() {
        return quotes;
    }


}
