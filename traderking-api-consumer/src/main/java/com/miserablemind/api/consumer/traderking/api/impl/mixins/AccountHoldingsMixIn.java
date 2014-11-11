/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.account.holdings.AccountHoldingEntry;

import java.util.List;

public class AccountHoldingsMixIn extends TKObjectMixIn {
  @JsonProperty("holding")
  List<AccountHoldingEntry> holdingsList;

  @JsonProperty("totalsecurities")
  double totalSecurities;

}
