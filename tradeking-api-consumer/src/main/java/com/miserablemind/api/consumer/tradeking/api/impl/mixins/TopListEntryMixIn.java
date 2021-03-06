/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.market.ChangeSign;

public class TopListEntryMixIn extends TradeKingKObjectMixIn {

    @JsonProperty("chg")
    double change;

    @JsonProperty("chg_sign")
    ChangeSign changeDirection;

    @JsonProperty("last")
    double lastTradePrice;

    @JsonProperty("name")
    String companyName;

    @JsonProperty("pchg")
    String percentageChange;

    @JsonProperty("pcls")
    double priorDayClosePrice;

    @JsonProperty("rank")
    int rankInTheList;

    @JsonProperty("symbol")
    String ticker;

    @JsonProperty("vl")
    int volume;

}
