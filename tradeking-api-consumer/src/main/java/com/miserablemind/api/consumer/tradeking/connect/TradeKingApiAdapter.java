/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.connect;

import com.miserablemind.api.consumer.tradeking.api.TradeKingOperations;
import com.miserablemind.api.consumer.tradeking.api.domain.member.UserProfile;
import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfileBuilder;

public class TradeKingApiAdapter implements ApiAdapter<TradeKingOperations> {
  @Override
  public boolean test(TradeKingOperations api) {
    try {
      api.getAPIOperations().getCurrentUser();
      return true;
    } catch (ApiException e) {
      return false;
    }
  }

  @Override
  public void setConnectionValues(TradeKingOperations api, ConnectionValues values) {
    UserProfile profile = api.getAPIOperations().getCurrentUser().getUserProfile();
    values.setProviderUserId(profile.getUUID());
    values.setDisplayName("@" + profile.getFirstName());
    values.setProfileUrl("");
    values.setImageUrl("");
  }

  @Override
  public org.springframework.social.connect.UserProfile fetchUserProfile(TradeKingOperations api) {
    UserProfile profile = api.getAPIOperations().getCurrentUser().getUserProfile();
    return new UserProfileBuilder().setName(profile.getFirstName()).setUsername(
            profile.getFirstName()).build();
  }

  @Override
  public void updateStatus(TradeKingOperations api, String message) {
    api.getAccountOperations().updateStatus();
  }
}
