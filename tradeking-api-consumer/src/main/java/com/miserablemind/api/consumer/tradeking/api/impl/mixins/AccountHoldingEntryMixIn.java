/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldingEntry;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.FinancialInstrument;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.HoldingDisplayData;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.HoldingsQuote;

public class AccountHoldingEntryMixIn extends TKObjectMixIn {

  @JsonProperty("accounttype")
  AccountHoldingEntry.HoldingType holdingType;

  @JsonProperty("costbasis")
  double costBasis;

  @JsonProperty("displaydata")
  HoldingDisplayData displayData;

  @JsonProperty("gainloss")
  double gainLoss;

  @JsonProperty("instrument")
  FinancialInstrument instrument;

  @JsonProperty("marketvalue")
  double marketValue;

  @JsonProperty("marketvaluechange")
  double marketValueChange;

  @JsonProperty("price")
  double price;

  @JsonProperty("purchaseprice")
  double purchasePrice;

  @JsonProperty("qty")
  double quantity;

  @JsonProperty("quote")
  HoldingsQuote holdingsQuote;

  @JsonProperty("sodcostbasis")
  double SODCostBasis;

}
