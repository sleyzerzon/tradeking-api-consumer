/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldingEntry;

public class AccountHoldingsMixIn extends TradeKingKObjectMixIn {
    @JsonProperty("holding")
    @JsonDeserialize(using = AccountHoldingsEntryDeserializer.class)
    AccountHoldingEntry[] holdingsList;

    @JsonProperty("totalsecurities")
    double totalSecurities;

}
