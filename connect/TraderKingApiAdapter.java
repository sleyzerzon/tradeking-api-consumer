package com.miserablemind.twtbeat.domain.service.traderking.connect;

import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.UserProfile;
import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
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
    UserProfile profile = api.getCurrentUser().getUserProfile();
    values.setProviderUserId(profile.getUUID());
    values.setDisplayName("@" + profile.getPrimaryFirstName());
    values.setProfileUrl("");
    values.setImageUrl("");
  }

  @Override
  public org.springframework.social.connect.UserProfile fetchUserProfile(TraderKingOperations api) {
    UserProfile profile = api.getCurrentUser().getUserProfile();
    return new UserProfileBuilder().setName(profile.getPrimaryFirstName()).setUsername(
            profile.getPrimaryFirstName()).build();
  }

  @Override
  public void updateStatus(TraderKingOperations api, String message) {
    api.updateStatus();
  }
}
