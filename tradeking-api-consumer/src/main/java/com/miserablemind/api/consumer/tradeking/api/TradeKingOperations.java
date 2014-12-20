/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

import com.miserablemind.api.consumer.tradeking.api.impl.*;

public interface TradeKingOperations {

  AccountTemplate getAccountOperations();

  WatchlistTemplate getWatchlistOperations();

  MarketTemplate getMarketOperations();

  StreamingTemplate getStreamingOperations();

  APITemplate getAPIOperations();
}
