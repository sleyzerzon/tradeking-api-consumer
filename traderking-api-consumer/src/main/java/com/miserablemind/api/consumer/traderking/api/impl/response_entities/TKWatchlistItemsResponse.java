/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.traderking.api.domain.watchlist.WatchlistItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class TKWatchlistItemsResponse extends TKResponse {

  private String error;

  private WatchlistItem[] watchListsItems;

  public String getError() {
    return error;
  }

  public WatchlistItem[] getWatchListItems() {
    return watchListsItems;
  }

  @JsonSetter("watchlists")
  public void setWatchLists(LinkedHashMap<String, LinkedHashMap> watchListsResponse) throws Exception {

    //manually deserialize as we need to un-nest some unnecessary stuff
    if (null == watchListsResponse.get("watchlist")) return;

    ArrayList<LinkedHashMap> items = new ArrayList<LinkedHashMap>();

    Object itemsContainer = watchListsResponse.get("watchlist").get("watchlistitem");

    //api does not wrap a single result
    if (itemsContainer.getClass() == ArrayList.class) {
      //we know it's ArrayList because of condition
      items = (ArrayList) itemsContainer;
    } else {
      items.add((LinkedHashMap) watchListsResponse.get("watchlist").get("watchlistitem"));
    }

    ArrayList<WatchlistItem> resultList = new ArrayList<WatchlistItem>();

    for (Object item : items) {

      LinkedHashMap itemEntries = (LinkedHashMap) item;
      double costBasis = Double.parseDouble((String) itemEntries.get("costbasis"));
      double quantity = Double.parseDouble((String) itemEntries.get("qty"));
      LinkedHashMap instrument = (LinkedHashMap) itemEntries.get("instrument");
      String ticker = (String) instrument.get("sym");

      WatchlistItem itemObject = new WatchlistItem(costBasis, quantity, ticker);
      resultList.add(itemObject);

    }

    this.watchListsItems = new WatchlistItem[resultList.size()];
    this.watchListsItems = resultList.toArray(this.watchListsItems);

  }
}
