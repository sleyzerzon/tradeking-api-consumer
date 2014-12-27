/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.api.consumer.tradeking.api.StreamListener;
import com.miserablemind.api.consumer.tradeking.api.domain.TKObject;
import com.miserablemind.api.consumer.tradeking.api.domain.market.StreamQuoteEvent;
import com.miserablemind.api.consumer.tradeking.api.domain.market.StreamTradeEvent;
import com.miserablemind.api.consumer.tradeking.api.impl.mixins.StreamQuoteMixIn;
import com.miserablemind.api.consumer.tradeking.api.impl.mixins.StreamTradeMixIn;
import com.miserablemind.api.consumer.tradeking.api.impl.mixins.TKObjectMixIn;

import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


class StreamDispatcher implements Runnable {

  private final List<StreamListener> listeners;

  private ObjectMapper objectMapper;

  private AtomicBoolean active;

  private final Queue<String> queue;

  private final ExecutorService pool;


  public StreamDispatcher(Queue<String> queue, List<StreamListener> listeners) {
    this.queue = queue;
    this.listeners = listeners;
    pool = Executors.newCachedThreadPool();
    objectMapper = new ObjectMapper();

    objectMapper.addMixInAnnotations(TKObject.class, TKObjectMixIn.class);
    objectMapper.addMixInAnnotations(StreamQuoteEvent.class, StreamQuoteMixIn.class);
    objectMapper.addMixInAnnotations(StreamTradeEvent.class, StreamTradeMixIn.class);
    objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

    active = new AtomicBoolean(true);
  }

  public void run() {
    while (active.get()) {

      String jsonEntry = queue.poll();
      if (jsonEntry == null || jsonEntry.length() == 0) return;

      try {
        if (jsonEntry.contains("{\"quote")) {
          handleQuote(jsonEntry);
        } else if (jsonEntry.startsWith("{\"trade")) {
          handleTrade(jsonEntry);
        }
      } catch (IOException e) {
        // could not map the line, will skip for now
      }
    }
  }

  public void stop() {
    active.set(false);
    pool.shutdown();
  }

  private void handleQuote(String jsonEntry) throws IOException {
    StreamQuoteEvent quoteEvent = objectMapper.readValue(jsonEntry, StreamQuoteEvent.class);
    for (final StreamListener listener : listeners) pool.submit((() -> listener.onQuote(quoteEvent)));
  }

  private void handleTrade(String jsonEntry) throws IOException {
    StreamTradeEvent tradeEvent = objectMapper.readValue(jsonEntry, StreamTradeEvent.class);
    for (StreamListener listener : listeners) pool.submit((() -> listener.onTrade(tradeEvent)));
  }


}
