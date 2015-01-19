/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.domain.market;


import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;

/**
 * TK API allows to subscribe to streams, one of them is Quotes
 * This object represents quote event that happens in the market.
 */
public class StreamQuoteEvent extends TradeKingObject {

    private double askPrice;
    private long askLatestSizeHundreds;
    private double bidPrice;
    private long bidLatestSizeHundreds;
    private Integer bidTick;
    private Calendar dateTime;
    private String exchangeCode;
    private String conditionCode;
    private String symbol;
    private int timeStamp;

    public StreamQuoteEvent() {
    }

    public StreamQuoteEvent(double askPrice, long askLatestSizeHundreds, double bidPrice, long bidLatestSize, Integer bidTick, Calendar dateTime, String exchangeCode, String conditionCode, String symbol, int timeStamp) {
        this.askPrice = askPrice;
        this.askLatestSizeHundreds = askLatestSizeHundreds;
        this.bidPrice = bidPrice;
        this.bidLatestSizeHundreds = bidLatestSize;
        this.bidTick = bidTick;
        this.dateTime = dateTime;
        this.exchangeCode = exchangeCode;
        this.conditionCode = conditionCode;
        this.symbol = symbol;
        this.timeStamp = timeStamp;
    }

    /**
     * Ask Price
     *
     * @return dollar figure
     */
    public double getAskPrice() {
        return askPrice;
    }

    /**
     * Size of latest ask (in 100's)
     *
     * @return integer size in hundreds
     */
    public long getAskLatestSizeHundreds() {
        return askLatestSizeHundreds;
    }

    /**
     * Bid Price
     *
     * @return dollar figure
     */
    public double getBidPrice() {
        return bidPrice;
    }

    /**
     * Size of latest bid (in 100's)
     *
     * @return integer size in hundreds
     */
    public long getBidLatestSizeHundreds() {
        return bidLatestSizeHundreds;
    }

    /**
     * "An indication of whether the latest bid price is higher, lower or the same as the previous bid"
     * TK returns 1, 3 or null. No documentation provided. Seems like 1 is down, 3 is up
     *
     * @return bid tick id if provided, otherwise {@code null}
     */
    public Integer getBidTick() {
        return bidTick;
    }

    /**
     * Date and time of the quote
     *
     * @return Date object
     */
    public Calendar getDateTime() {
        return dateTime;
    }

    /**
     * Exchange code
     *
     * @return String exchange code description
     */
    public String getExchangeCode() {
        return exchangeCode;
    }

    /**
     * Condition of quote, i.e. "Regular, two-sided open quote automated"
     *
     * @return String condition description
     */
    public String getConditionCode() {
        return conditionCode;
    }

    /**
     * Symbol from data provider
     *
     * @return string instrument symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Timestamp
     *
     * @return integer timestamp
     */
    public int getTimeStamp() {
        return timeStamp;
    }
}
