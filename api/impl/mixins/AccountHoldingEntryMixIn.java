package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.FinancialInstrument;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.HoldingDisplayData;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.HoldingsQuote;

public class AccountHoldingEntryMixIn extends TKObjectMixIn {

  @JsonProperty("accounttype")
  int accountType;

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