/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

public interface TradeKingOperations {

  AccountOperations getAccountOperations();

  WatchlistOperations getWatchlistOperations();

  MarketOperations getMarketOperations();

  StreamingOperations getStreamingOperations();

  APIOperations getAPIOperations();
}
