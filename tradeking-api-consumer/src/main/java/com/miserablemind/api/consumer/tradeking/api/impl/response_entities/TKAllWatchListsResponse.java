/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */
package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TKAllWatchListsResponse extends TKResponse {


    private String error;

    private String[] watchLists;

    public String getError() {
        return error;
    }

    public String[] getWatchLists() {
        return watchLists;
    }

    @JsonSetter("watchlists")
    public void setWatchLists(LinkedHashMap<String, Object> watchListsResponse) throws Exception {

        ArrayList<String> resultList = new ArrayList<String>();

        Object list = watchListsResponse.get("watchlist");

        ArrayList<LinkedHashMap<String, String>> itemList = new ArrayList<LinkedHashMap<String, String>>();

        if (list.getClass() == ArrayList.class) {
            //we know from condition this is right
            itemList = (ArrayList) list;
        } else {
            itemList.add((LinkedHashMap) watchListsResponse.get("watchlist"));
        }

        for (LinkedHashMap<String, String> item : itemList) resultList.add(item.get("id"));

        this.watchLists = new String[resultList.size()];
        this.watchLists = resultList.toArray(this.watchLists);

    }
}
