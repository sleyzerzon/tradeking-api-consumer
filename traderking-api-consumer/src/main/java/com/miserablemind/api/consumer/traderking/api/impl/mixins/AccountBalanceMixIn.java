/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.BuyingPower;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.Cash;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.Securities;

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
