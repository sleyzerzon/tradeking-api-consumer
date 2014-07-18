package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;

public class TKAllAccountsSummaryMixIn extends TKObjectMixIn {

  @JsonProperty("account")
  String accountId;

  @JsonProperty("accountbalance")
  AccountBalance accountBalance;

  @JsonProperty("accountholdings")
  AccountHoldings accountHoldings;
}
