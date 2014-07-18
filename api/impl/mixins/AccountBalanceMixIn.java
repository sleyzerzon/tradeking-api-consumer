package com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.BuyingPower;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.Cash;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.Securities;

public class AccountBalanceMixIn extends TKObjectMixIn {

  @JsonProperty("account")
  int accountId;

  @JsonProperty("accountvalue")
  double accountValue;

  @JsonProperty("backofficehouseexcess")
  double backOfficeHouseExcess;

  @JsonProperty("buyingpower")
  BuyingPower buyingPowerSummary;

  @JsonProperty("fedcall")
  double fedCall;

  @JsonProperty("housecall")
  double houseCall;

  @JsonProperty("maintenanceexcess")
  double maintenanceExcess;

  @JsonProperty("money")
  Cash cashSummary;

  @JsonProperty("securities")
  Securities securitiesSummary;

}
