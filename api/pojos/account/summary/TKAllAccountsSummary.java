package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;

//todo: verify with docs about missing fields
public class TKAllAccountsSummary extends TKObject {

  @JsonProperty("account")
  private String accountId;

  @JsonProperty("accountbalance")
  private AccountBalance accountBalance;

  @JsonProperty("accountholdings")
  private AccountHoldings accountHoldings;


}
