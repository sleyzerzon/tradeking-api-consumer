/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

import com.miserablemind.api.consumer.tradeking.api.domain.watchlist.WatchlistItem;

public interface WatchlistOperations {

  public String[] getAllLists();

  public String[] addList(String watchlistName, String[] tickers) throws Exception;

  public void deleteListById(String watchlistName);

  public String[] addSymbolsToList(String watchlistName, String[] tickers);

  public void deleteSymbolFromList(String watchlistName, String[] tickers);

  public WatchlistItem[] getItems(String watchlistName);
}
