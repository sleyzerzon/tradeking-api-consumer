/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;

import com.miserablemind.api.consumer.tradeking.api.StreamListener;
import com.miserablemind.api.consumer.tradeking.api.StreamingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class StreamReaderImpl implements StreamReader {

  private AtomicBoolean open;

  private final InputStream inputStream;

  private final BufferedReader reader;

  private final Queue<String> queue;

  private final StreamDispatcher dispatcher;

  private final ScheduledFuture<?> future;

  public StreamReaderImpl(InputStream inputStream, List<StreamListener> listeners) {
    this.inputStream = inputStream;
    this.reader = new BufferedReader(new InputStreamReader(inputStream));
    this.queue = new ConcurrentLinkedQueue<>();
    this.dispatcher = new StreamDispatcher(queue, listeners);
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
    this.future = executor.scheduleAtFixedRate(dispatcher, 0, 10, TimeUnit.MILLISECONDS);
    this.open = new AtomicBoolean(true);
  }

  public void next() {
    try {
      StringBuilder stringBuilder = new StringBuilder();

      int character;
      do {
        character = this.reader.read();
        stringBuilder.append(Character.toChars(character));

        if (character == 125 // current character }
          &&
          (
            (stringBuilder.length() >= 2 && stringBuilder.charAt(stringBuilder.length() - 2) == 125)  //previous character }
              ||
              (stringBuilder.toString().equals("{\"status\":\"connected\"}")) // initial "connected" message
          )
          ) {
          break;
        }
      } while (character != -1);

      String streamEntry = stringBuilder.toString();

      this.queue.add(streamEntry);

    } catch (IOException e) {
      if (this.open.get()) {
        this.close();
        throw new StreamingException("The Stream is closed", e);
      }
    }
  }

  public void close() {
    try {
      this.open.set(false);
      this.future.cancel(true);
      this.dispatcher.stop();
      this.inputStream.close();
    } catch (IOException ignore) {
    }
  }

}
