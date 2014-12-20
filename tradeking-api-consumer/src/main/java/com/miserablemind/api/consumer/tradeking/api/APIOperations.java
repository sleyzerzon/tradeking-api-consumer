/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;


import com.miserablemind.api.consumer.tradeking.api.domain.member.TKUser;

public interface APIOperations {

  public String getAPIVersion();

  public TKUser getCurrentUser();


}
