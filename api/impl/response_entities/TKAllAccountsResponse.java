package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@JsonRootName("response")
public class TKAllAccountsResponse extends TKObject {


  private String error;

  private AccountsSummary[] accounts;

  public String getError() {
    return error;
  }

  public AccountsSummary[] getAccounts() {
    return accounts;
  }

  @JsonSetter("accounts")
  public void setAccounts(LinkedHashMap accountsResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new TraderKingModule());

    Object accountsContainer = accountsResponse.get("accountsummary");

    String jsonArray = mapper.writeValueAsString(accountsContainer);

    //API returns list if multiple quotes objects, but a quote object if only one. Standardize here.
    if (accountsContainer.getClass() == ArrayList.class)
      this.accounts = mapper.readValue(jsonArray, AccountsSummary[].class);
    else this.accounts = new AccountsSummary[]{mapper.readValue(jsonArray, AccountsSummary.class)};

  }

}

