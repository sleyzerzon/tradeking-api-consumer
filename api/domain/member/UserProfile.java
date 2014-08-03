package com.miserablemind.twtbeat.domain.service.traderking.api.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.TKObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * For User Profile TraderKing returns an array instead of some sensible normal object
 * The getter methods get it from the List that is turned into hash map for faster access.
 */
public class UserProfile extends TKObject {

  @JsonIgnore
  private HashMap<String, String> data = new HashMap<String, String>();

  private ArrayList<LinkedHashMap<String, String>> entry;

  private ArrayList<LinkedHashMap<String, String>> getEntry() {
    return entry;
  }

  @JsonSetter("entry")
  public void setEntry(ArrayList<LinkedHashMap<String, String>> entry) {
    this.entry = entry;
    for (LinkedHashMap<String, String> data : entry) this.data.put(data.get("name"), data.get("value"));
  }

  public String getUUID() {
    return this.data.get("UUID");
  }

  public String getAccountSummaryDashboardCollapsed() {
    return this.data.get("accountSummaryDashboardCollapsed");
  }

  public String getPrimaryFirstName() {
    return this.data.get("primaryFirstName");
  }

  public String getPrimaryLastName() {
    return this.data.get("primaryLastName");
  }

  public boolean hasNewMessages() {
    return (this.data.get("NewMsg").equals("Y"));
  }

  public boolean isRealTimeStockQuote() {
    return (this.data.get("rtq").equals("Y"));
  }

  public String getEmailAddress() {
    return this.data.get("emailAddress1");
  }

  public String getFDICPaper() {
    return this.data.get("fdicPaper");
  }

  public boolean isGainsKeeper() {
    return (this.data.get("gainsKeeper").equals("Y"));
  }

  public boolean IsTradingPasswordUsed() {
    return (this.data.get("useTradingPassword").equals("Y"));
  }

  public String getFDICAgreement() {
    return this.data.get("AGREEMENT_FDIC");
  }


}
