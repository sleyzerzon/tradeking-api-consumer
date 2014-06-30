package com.miserablemind.twtbeat.domain.service.traderking.api.response_entities;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary.Accounts;

@JsonRootName("response")
public class TKAllAccountsResponse extends TKObject {

  private String error;

  private Accounts accounts;

  public String getError() {
    return error;
  }

  public Accounts getAccounts() {
    return accounts;
  }
}

