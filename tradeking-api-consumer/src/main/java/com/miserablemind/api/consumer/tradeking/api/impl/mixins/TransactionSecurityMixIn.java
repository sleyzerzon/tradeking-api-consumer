/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionSecurityMixIn extends TradeKingKObjectMixIn {

    @JsonProperty("cusip")
    String CUSIP;

    @JsonProperty("id")
    String id;

    @JsonProperty("sectyp")
    String securityType;

    @JsonProperty("sym")
    String symbol;

}
