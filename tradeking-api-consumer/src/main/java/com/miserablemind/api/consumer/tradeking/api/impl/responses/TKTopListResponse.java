/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.responses;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.market.TopListEntry;

import java.util.Map;

public class TKTopListResponse extends TKResponse {

    private String error;

    private TopListEntry[] topList;

    @JsonSetter("quotes")
    public void setQuotes(Map topListResponse) throws Exception {
        this.topList = (TopListEntry[]) this.extractArray(TopListEntry[].class, topListResponse, "quote");
    }


    public String getError() {
        return error;
    }

    public TopListEntry[] getTopList() {
        return this.topList;
    }
}
