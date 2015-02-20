/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TradeKingTransaction;

import java.util.LinkedHashMap;

public class TKHistoryResponse extends TKResponse {

    private String error;

    private TradeKingTransaction[] transactionHistory;

    public String getError() {
        return error;
    }

    public TradeKingTransaction[] getTransactionHistory() {
        return transactionHistory;
    }

    @JsonSetter("transactions")
    public void setTransactionHistory(LinkedHashMap historyResponse) throws Exception {
        this.transactionHistory = (TradeKingTransaction[]) this.extractArray(TradeKingTransaction[].class, historyResponse, "transaction");
    }
}
