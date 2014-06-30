package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

public class Accounts extends TKObject {

  @JsonProperty("accountsummary")
  private TKAllAccountsSummary accountSummary;

  public TKAllAccountsSummary getAccountSummary() {
    return accountSummary;
  }
}
