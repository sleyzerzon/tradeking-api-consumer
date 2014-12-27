/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;


import com.miserablemind.api.consumer.tradeking.api.domain.market.StreamQuoteEvent;
import com.miserablemind.api.consumer.tradeking.api.domain.market.StreamTradeEvent;

public interface StreamListener {

  void onTrade(StreamTradeEvent tradeEvent);

  void onQuote(StreamQuoteEvent quoteEvent);
}