/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * Top list entry. Top List are "biggest volumes today", "biggest gainers, losers", etc.
 */
public class TopListEntry extends TradeKingObject {

    private double change;
    private ChangeSign changeDirection;
    private double lastTradePrice;
    private String companyName;
    private String percentageChange;
    private double priorDayClosePrice;
    private int rankInTheList;
    private String ticker;
    private int volume;

    public TopListEntry() {
    }

    public TopListEntry(double change, ChangeSign changeDirection, double lastTradePrice, String companyName, String percentageChange, double priorDayClosePrice, int rankInTheList, String ticker, int volume) {
        this.change = change;
        this.changeDirection = changeDirection;
        this.lastTradePrice = lastTradePrice;
        this.companyName = companyName;
        this.percentageChange = percentageChange;
        this.priorDayClosePrice = priorDayClosePrice;
        this.rankInTheList = rankInTheList;
        this.ticker = ticker;
        this.volume = volume;
    }

    /**
     * Change since prior day close (cl)
     *
     * @return dollar figure
     */
    public double getChange() {
        return change;
    }

    /**
     * Change sign: up, down, did not change.
     *
     * @return enum with a change value
     */
    public ChangeSign getChangeDirection() {
        return changeDirection;
    }

    /**
     * Last trade price
     *
     * @return dollar figure
     */
    public double getLastTradePrice() {
        return lastTradePrice;
    }

    /**
     * Company name
     *
     * @return String company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Percentage change from prior day close
     *
     * @return percent String todo://perhaps double is better
     */
    public String getPercentageChange() {
        return percentageChange;
    }

    /**
     * Prior day close
     *
     * @return dollar figure
     */
    public double getPriorDayClosePrice() {
        return priorDayClosePrice;
    }

    /**
     * Rank within list returned
     *
     * @return integer rank number
     */
    public int getRankInTheList() {
        return rankInTheList;
    }

    /**
     * Ticker symbol
     *
     * @return String ticker symbol
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Today's cumulative volume
     *
     * @return integer volume number
     */
    public int getVolume() {
        return volume;
    }

}
