/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.StreamingOperations;
import org.springframework.web.client.RestTemplate;

public class StreamingTemplate extends BaseTemplate implements StreamingOperations {
  StreamingTemplate(RestTemplate restTemplate) {
    super(restTemplate);
  }
}
