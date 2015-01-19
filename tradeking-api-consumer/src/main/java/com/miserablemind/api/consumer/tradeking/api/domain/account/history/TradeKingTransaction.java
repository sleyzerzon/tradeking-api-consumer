/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.account.history;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;


/**
 * A class that holds all the data about a transaction that happened in the past
 */
public class TradeKingTransaction extends TradeKingObject {

    private Type activityType;
    private double amount;
    private Calendar date;
    private String description;
    private String symbol;
    private TransactionDetails transactionDetails;

    public TradeKingTransaction() {
    }

    public TradeKingTransaction(Type activity, double amount, Calendar date, String description, String symbol, TransactionDetails transactionDetails) {
        this.activityType = activity;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.symbol = symbol;
        this.transactionDetails = transactionDetails;
    }

    /**
     * Type of the transaction
     *
     * @return enum of activity type
     */
    public Type getActivityType() {
        return activityType;
    }

    /**
     * Transaction amount. Negative if bought something, positive if sold.
     *
     * @return dollar figure
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Date of the transaction. Seems to have the date accurate, all the hours are midnight for New York (-05:00)
     *
     * @return transaction date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Display friendly description. Company name and brief transaction description (for some transaction types)
     *
     * @return String brief transaction description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Symbol of the instrument
     *
     * @return String symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * More details about transaction itself
     *
     * @return TransactionDetails Object
     */
    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    /**
     * Transaction Type
     */
    public enum Type {
        ALL("All"), TRADE("Trade"), DIVIDEND("Dividend"), BOOK_KEEPING("Bookkeeping"), INTEREST("Interest");
        private String value;

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    /**
     * When pulling transactions, these are the filters to use
     */
    public enum Range {
        ALL("all"), TODAY("today"), CURRENT_WEEK("current_week"), CURRENT_MONTH("current_month"), LAST_MONTH("last_month");
        private String value;

        Range(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeKingTransaction)) return false;

        TradeKingTransaction that = (TradeKingTransaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (activityType != that.activityType) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (transactionDetails != null ? !transactionDetails.equals(that.transactionDetails) : that.transactionDetails != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = activityType != null ? activityType.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (transactionDetails != null ? transactionDetails.hashCode() : 0);
        return result;
    }
}
