/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;


import com.miserablemind.api.consumer.tradeking.api.domain.member.TKUser;

/**
 * Sub-api that proves data about API itself
 */
public interface APIOperations {

  /**
   * Gets API version for the api connected to
   *
   * @return a String with api version
   */
  public String getAPIVersion();

  /**
   * Gets the connected user that is authorized to use the api
   *
   * @return User object
   */
  public TKUser getCurrentUser();


}
