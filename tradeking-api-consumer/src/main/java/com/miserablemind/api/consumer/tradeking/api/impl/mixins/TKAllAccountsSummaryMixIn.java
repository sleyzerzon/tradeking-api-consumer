/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldings;

public class TKAllAccountsSummaryMixIn extends TradeKingKObjectMixIn {

    @JsonProperty("account")
    String accountId;

    @JsonProperty("accountbalance")
    AccountBalance accountBalance;

    @JsonProperty("accountholdings")
    AccountHoldings accountHoldings;
}
