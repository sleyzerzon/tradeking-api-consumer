package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.TKUser;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.UserAccount;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.UserProfile;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TKUserResponse extends TKResponse {

  enum UserProfileKeys {

    UUID("UUID"),
    GAINS_KEEPER("gainsKeeper"),
    LAST_NAME("primaryLastName"),
    DASHBOARD_COLLAPSED("accountSummaryDashboardCollapsed"),
    NEW_MESSAGE("NewMsg"),
    FIRST_NAME("primaryFirstName"),
    REAL_TIME_STOCK_QUOTE("rtq"),
    EMAIL_ADDRESS("emailAddress1"),
    FDIC_PAPER("fdicPaper"),
    AGREEMENT_FDIC("AGREEMENT_FDIC"),
    USE_TRADING_PASSWORD("useTradingPassword");

    private final String key;

    UserProfileKeys(String key) {
      this.key = key;
    }

    public static UserProfileKeys fromString(String key) {
      if (key != null) {
        for (UserProfileKeys b : UserProfileKeys.values()) {
          if (key.equalsIgnoreCase(b.key)) {
            return b;
          }
        }
      }
      return null;
    }
  }

  private String error;

  @JsonIgnore
  private TKUser user;

  /**
   * For User Profile TraderKing returns an array instead of some sensible normal object
   * The getter methods get it from the List that is turned into hash map for faster access.
   */
  @JsonSetter("userdata")
  public void deserializeUserData(LinkedHashMap<String, Object> userData) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new TraderKingModule());

    boolean isDisabled = userData.get("disabled").equals("true");
    boolean resetPassword = userData.get("resetpassword").equals("true");
    boolean resetTradingPassword = userData.get("resettradingpassword").equals("true");

    String jsonArray = mapper.writeValueAsString(userData.get("account"));
    UserAccount account = mapper.readValue(jsonArray, UserAccount.class);

    //User Profile Object
    UserProfile userProfile = new UserProfile();

    LinkedHashMap<String, ArrayList> data = (LinkedHashMap<String, ArrayList>) userData.get("userprofile");
    ArrayList<LinkedHashMap<String, String>> entry = (ArrayList<LinkedHashMap<String, String>>) data.get("entry");

    for (LinkedHashMap<String, String> entryLine : entry) {
      UserProfileKeys key = UserProfileKeys.fromString(entryLine.get("name"));

      //catch all
      if (null == key) {
        userProfile.add(entryLine.get("name"), entryLine.get("value"));
        continue;
      }

      switch (key) {
        case AGREEMENT_FDIC:
          userProfile.setFDICAgreement(entryLine.get("value"));
          break;
        case DASHBOARD_COLLAPSED:
          userProfile.setAccountSummaryDashboardCollapsed(entryLine.get("value"));
          break;
        case EMAIL_ADDRESS:
          userProfile.setEmailAddress(entryLine.get("value"));
          break;
        case UUID:
          userProfile.setUUID(entryLine.get("value"));
          break;
        case FDIC_PAPER:
          userProfile.setFDICPaper(entryLine.get("value"));
          break;
        case FIRST_NAME:
          userProfile.setFirstName(entryLine.get("value"));
          break;
        case GAINS_KEEPER:
          userProfile.setGainsKeeper(entryLine.get("value").equals("Y"));
          break;
        case LAST_NAME:
          userProfile.setLasName(entryLine.get("value"));
          break;
        case NEW_MESSAGE:
          userProfile.setHasMewMessage(entryLine.get("value").equals("Y"));
          break;
        case REAL_TIME_STOCK_QUOTE:
          userProfile.setRealTimeStockQuote(entryLine.get("value").equals("Y"));
          break;
        case USE_TRADING_PASSWORD:
          userProfile.setTradingPasswordUsed(entryLine.get("value").equals("Y"));
          break;
        default:
          userProfile.add(entryLine.get("name"), entryLine.get("value"));
      }
    }

    this.user = new TKUser(isDisabled, resetPassword, resetTradingPassword, account, userProfile);

  }

  public TKUser getUserData() {
    return user;
  }

  public String getError() {
    return error;
  }
}

