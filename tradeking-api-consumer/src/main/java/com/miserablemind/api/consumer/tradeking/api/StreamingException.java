/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

import org.springframework.social.SocialException;

@SuppressWarnings("serial")
public class StreamingException extends SocialException {

  public StreamingException(String message, Throwable cause) {
    super(message, cause);
  }

}
