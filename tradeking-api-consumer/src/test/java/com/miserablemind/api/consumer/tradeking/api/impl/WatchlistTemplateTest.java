package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.watchlist.WatchlistItem;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.ApiException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class WatchlistTemplateTest extends BaseTemplateTest {

  @Test
  public void getAllLists() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("watchlist/all_lists"), MediaType.APPLICATION_JSON));
    String[] watchlistNames = tradeKing.getWatchlistOperations().getAllLists();

    assertArrayEquals("Watch Lists names do not match", watchlistNames, mockData.watchLists);
  }

  @Test(expected = ApiException.class)
  public void getAllLists_errorResponse() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));
    String[] watchlistNames = tradeKing.getWatchlistOperations().getAllLists();

  }

  @Test
  public void addList() {
    //todo figure out how to match post vars
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists.json"))
      .andExpect(method(POST))
      .andRespond(withSuccess(jsonResource("watchlist/all_lists"), MediaType.APPLICATION_JSON));
    String[] watchlistNames = tradeKing.getWatchlistOperations().addList("some Name", new String[]{"TCK1", "TCK2"});

    assertArrayEquals("Watch Lists names do not match", watchlistNames, mockData.watchLists);
  }

  @Test(expected = ApiException.class)
  public void addList_errorResponse() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists.json"))
      .andExpect(method(POST))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));
    String[] watchlistNames = tradeKing.getWatchlistOperations().addList("some Name", new String[]{"TCK1", "TCK2"});
  }

  @Test
  public void deleteListById() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists/DEFAULT.json"))
      .andExpect(method(DELETE))
      .andRespond(withSuccess(jsonResource("watchlist/all_lists"), MediaType.APPLICATION_JSON));
    tradeKing.getWatchlistOperations().deleteListById("DEFAULT");
  }

  @Test
  public void addSymbolsToList() {
    //todo figure out how to match post vars
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists/DEFAULT/symbols.json"))
      .andExpect(method(POST))
      .andRespond(withSuccess(jsonResource("watchlist/all_lists"), MediaType.APPLICATION_JSON));

    String[] watchlistNames = tradeKing.getWatchlistOperations().addSymbolsToList("DEFAULT", new String[]{"TCKR1", "TCKR2"});
    assertArrayEquals("Watch Lists names do not match", watchlistNames, mockData.watchLists);
  }

  @Test(expected = ApiException.class)
  public void addSymbolsToList_errorResponse() {
    //todo figure out how to match post vars
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists/DEFAULT/symbols.json"))
      .andExpect(method(POST))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));
    String[] watchlistNames = tradeKing.getWatchlistOperations().addSymbolsToList("DEFAULT", new String[]{"TCKR1", "TCKR2"});
  }

  @Test
  public void deleteSymbolFromList() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists/DEFAULT/symbols/TCKR1,TCKR2.json"))
      .andExpect(method(DELETE))
      .andRespond(withSuccess(jsonResource("watchlist/all_lists"), MediaType.APPLICATION_JSON));
    tradeKing.getWatchlistOperations().deleteSymbolFromList("DEFAULT", new String[]{"TCKR1", "TCKR2"});
  }

  @Test
  public void getItems() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists/DEFAULT.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("watchlist/list_contents"), MediaType.APPLICATION_JSON));

    WatchlistItem[] items = tradeKing.getWatchlistOperations().getItems("DEFAULT");

    assertEquals("First Item Object does not match", items[0], mockData.watchlistItem1);
    assertEquals("Second Item Object does not match", items[1], mockData.watchlistItem2);

  }

  @Test(expected = ApiException.class)
  public void getItems_errorResponse() {
    mockServer.expect(requestTo(BaseTemplate.URL_BASE + "watchlists/DEFAULT.json"))
      .andExpect(method(GET))
      .andRespond(withSuccess(jsonResource("error_response"), MediaType.APPLICATION_JSON));

    WatchlistItem[] items = tradeKing.getWatchlistOperations().getItems("DEFAULT");
  }

}
