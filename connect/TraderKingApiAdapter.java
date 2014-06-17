package com.miserablemind.twtbeat.domain.service.traderking.connect;

import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingUser;
import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

public class TraderKingApiAdapter implements ApiAdapter<TraderKingOperations> {
  @Override
  public boolean test(TraderKingOperations api) {
    try {
      api.getCurrentUser();
      return true;
    } catch (ApiException e) {
      return false;
    }
  }

  @Override
  public void setConnectionValues(TraderKingOperations api, ConnectionValues values) {
    TraderKingUser profile = api.getCurrentUser();
    values.setProviderUserId(profile.getUserId());
    values.setDisplayName("@" + profile.getUsername());
    values.setProfileUrl(profile.getUrl());
    values.setImageUrl(profile.getPicture());
  }

  @Override
  public UserProfile fetchUserProfile(TraderKingOperations api) {
    TraderKingUser profile = api.getCurrentUser();
    return new UserProfileBuilder().setName(profile.getFirstName()).setUsername(
            profile.getUsername()).build();
  }

  @Override
  public void updateStatus(TraderKingOperations api, String message) {
    api.updateStatus();
  }
}
