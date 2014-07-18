package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyingPowerMixIn extends TKObjectMixIn {

  @JsonProperty("cashavailableforwithdrawal")
  double cashAvailableForWithdrawal;

  @JsonProperty("equitypercentage")
  double equityPercentage;

  @JsonProperty("options")
  double options;

  @JsonProperty("sodoptions")
  double sodOptions;

  @JsonProperty("sodstock")
  double sodStock;

  @JsonProperty("stock")
  double stock;

}
