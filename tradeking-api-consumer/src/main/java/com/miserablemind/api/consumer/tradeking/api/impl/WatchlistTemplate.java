/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;

import com.miserablemind.api.consumer.tradeking.api.WatchlistOperations;
import com.miserablemind.api.consumer.tradeking.api.domain.watchlist.WatchlistItem;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.TKAllWatchListsResponse;
import com.miserablemind.api.consumer.tradeking.api.impl.response_entities.TKWatchlistItemsResponse;
import com.miserablemind.api.consumer.tradeking.connect.TradeKingServiceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.social.ApiException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


public class WatchlistTemplate extends BaseTemplate implements WatchlistOperations {

  private static final String URL_WATCHLIST_LIST = "watchlists.json";
  private static final String URL_WATCHLIST_LIST_DELETE = "watchlists/%s.json";
  private static final String URL_WATCHLIST_LIST_EDIT = "watchlists/%s/symbols.json";
  private static final String URL_WATCHLIST_LIST_DELETE_TICKERS = "watchlists/%s/symbols/%s.json";
  private static final String URL_WATCHLIST_GET_ITEMS = "watchlists/%s.json";

  WatchlistTemplate(RestTemplate restTemplate) {
    super(restTemplate);
  }

  @Override
  public String[] getAllLists() {

    URI url = this.buildUri(URL_WATCHLIST_LIST);
    ResponseEntity<TKAllWatchListsResponse> response = this.getRestTemplate().getForEntity(url, TKAllWatchListsResponse.class);

    if (response.getBody().getError() != null)
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getWatchLists();

  }

  @Override
  public String[] addList(String watchlistName, String[] tickers) throws Exception {

    if (null == tickers) throw new Exception("Cannot create empty list");
    URI url = this.buildUri(URL_WATCHLIST_LIST);
    MultiValueMap<String, Object> requestObject = new LinkedMultiValueMap<String, Object>();
    requestObject.add("id", watchlistName);
    requestObject.add("symbols", this.buildURIFromParamList(tickers));

    ResponseEntity<TKAllWatchListsResponse> response = this.getRestTemplate().postForEntity(url, requestObject, TKAllWatchListsResponse.class);

    if (response.getBody().getError() != null)
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getWatchLists();
  }

  @Override
  public void deleteListById(String watchlistName) {
    URI url = this.buildUri(String.format(URL_WATCHLIST_LIST_DELETE, watchlistName));
    this.getRestTemplate().delete(url);
  }

  @Override
  public String[] addSymbolsToList(String watchlistName, String[] tickers) {
    URI url = this.buildUri(String.format(URL_WATCHLIST_LIST_EDIT, watchlistName));
    MultiValueMap<String, Object> requestObject = new LinkedMultiValueMap<String, Object>();
    requestObject.add("symbols", this.buildURIFromParamList(tickers));

    ResponseEntity<TKAllWatchListsResponse> response = this.getRestTemplate().postForEntity(url, requestObject, TKAllWatchListsResponse.class);

    if (response.getBody().getError() != null)
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getWatchLists();
  }

  @Override
  public void deleteSymbolFromList(String watchlistName, String[] tickers) {
    String tickersString = this.buildURIFromParamList(tickers);
    URI url = this.buildUri(String.format(URL_WATCHLIST_LIST_DELETE_TICKERS, watchlistName, tickersString));
    this.getRestTemplate().delete(url);
  }

  @Override
  public WatchlistItem[] getItems(String watchlistName) {

    URI url = this.buildUri(String.format(URL_WATCHLIST_GET_ITEMS, watchlistName));

    ResponseEntity<TKWatchlistItemsResponse> response = this.getRestTemplate().getForEntity(url, TKWatchlistItemsResponse.class);

    if (response.getBody().getError() != null && !response.getBody().getError().equals("Success"))
      throw new ApiException(TradeKingServiceProvider.PROVIDER_ID, response.getBody().getError());

    return response.getBody().getWatchListItems();

  }

}