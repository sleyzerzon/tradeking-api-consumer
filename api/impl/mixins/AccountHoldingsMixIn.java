package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.holdings.AccountHoldingEntry;

import java.util.List;

public class AccountHoldingsMixIn extends TKObjectMixIn {
  @JsonProperty("holding")
  List<AccountHoldingEntry> holdingsList;

  @JsonProperty("totalsecurities")
  double totalSecurities;

}
