/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.traderking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.traderking.api.domain.account.holdings.AccountHoldings;

public class TKAllAccountsSummaryMixIn extends TKObjectMixIn {

  @JsonProperty("account")
  String accountId;

  @JsonProperty("accountbalance")
  AccountBalance accountBalance;

  @JsonProperty("accountholdings")
  AccountHoldings accountHoldings;
}
