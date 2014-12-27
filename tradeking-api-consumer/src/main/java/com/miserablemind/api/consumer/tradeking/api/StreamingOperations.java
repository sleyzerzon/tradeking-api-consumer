/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

import com.miserablemind.api.consumer.tradeking.api.impl.Stream;

import java.util.List;

public interface StreamingOperations {

  Stream quotesAndTradesStream(final List<StreamListener> listeners, String[] quotes);

}
