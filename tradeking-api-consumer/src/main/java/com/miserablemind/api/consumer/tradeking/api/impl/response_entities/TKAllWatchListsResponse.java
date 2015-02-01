/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */
package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

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
    @SuppressWarnings("unchecked")
    public void setWatchLists(LinkedHashMap<String, Object> watchListsResponse) throws Exception {

        ArrayList<String> resultList = new ArrayList<String>();

        Object list = watchListsResponse.get("watchlist");

        ArrayList<LinkedHashMap<String, String>> itemList = new ArrayList<LinkedHashMap<String, String>>();

        if (list.getClass() == ArrayList.class) {
            //we know from condition this is right
            itemList = (ArrayList) list;
        } else {
            //todo: not covered by test
            itemList.add((LinkedHashMap) watchListsResponse.get("watchlist"));
        }

        resultList.addAll(itemList.stream().map(item -> item.get("id")).collect(Collectors.toList()));

        this.watchLists = new String[resultList.size()];
        this.watchLists = resultList.toArray(this.watchLists);

    }
}
