/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

import com.miserablemind.api.consumer.tradeking.api.domain.watchlist.WatchlistItem;

/**
 * Sub api to get, create, edit and delete watch lists
 */
public interface WatchlistOperations {

    /**
     * This will retrieve a list of watchlists for the authenticated user.
     *
     * @return a list of Strings that represent watchlist names
     */
    public String[] getAllLists();

    /**
     * This will create a watchlist with the specified id (name) for the authenticated user.
     *
     * @param watchlistName name (also in api docs referenced as id) of a watchlist to create
     * @param tickers       symbols of the stock to add to watchlist. At least one ticker must be provided.
     * @return new list of watchlist names, including the new one if it was added successfully
     */
    public String[] addList(String watchlistName, String[] tickers);

    /**
     * This will delete the watchlist with the name provided
     *
     * @param watchlistName name of the watchlist to delete
     */
    public void deleteListById(String watchlistName);

    /**
     * This will add the symbols in the form parameters to the watchlist with the name provided.
     *
     * @param watchlistName the name of the watchlist to add tickers to
     * @param tickers       a list of tickers to add
     * @return list of names of the watchlists
     */
    public String[] addSymbolsToList(String watchlistName, String[] tickers);

    /**
     * This will delete the symbols provided for the watchlist
     *
     * @param watchlistName the name of the watchlist to remove tickers from
     * @param tickers       ticker to remove from the watchlist
     */
    public void deleteSymbolFromList(String watchlistName, String[] tickers);

    /**
     * This will get watchilist items
     *
     * @param watchlistName the name of watchlist to get items for
     * @return a list of watchlist items
     */
    public WatchlistItem[] getItems(String watchlistName);
}
