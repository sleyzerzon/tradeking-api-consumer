/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TradeKingTransaction;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TransactionDetails;
import org.joda.time.DateTime;

public class TradeKingTransactionMixIn extends TradeKingKObjectMixIn {

    @JsonProperty("activity")
    TradeKingTransaction.Type activityType;

    @JsonProperty("amount")
    double amount;

    @JsonProperty("date")
    DateTime date;

    @JsonProperty("desc")
    String description;

    @JsonProperty("symbol")
    String symbol;

    @JsonProperty("transaction")
    TransactionDetails transactionDetails;


}
