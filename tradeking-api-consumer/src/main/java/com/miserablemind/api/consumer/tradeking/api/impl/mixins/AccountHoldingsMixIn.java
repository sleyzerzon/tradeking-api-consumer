/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldingEntry;

import java.util.List;

public class AccountHoldingsMixIn extends TradeKingKObjectMixIn {
  @JsonProperty("holding")
  List<AccountHoldingEntry> holdingsList;

  @JsonProperty("totalsecurities")
  double totalSecurities;

}
