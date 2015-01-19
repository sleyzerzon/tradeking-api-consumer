/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;

/**
 * News Headline
 */
public class NewsHeadline extends TradeKingObject {
    private String id;
    private String headline;
    private Calendar date;

    public NewsHeadline() {
    }

    public NewsHeadline(String id, String headline, Calendar date) {
        this.id = id;
        this.headline = headline;
        this.date = date;
    }

    /**
     * Article id used for article retrieval
     *
     * @return String article id
     */
    public String getId() {
        return id;
    }

    /**
     * The title of the article
     *
     * @return String headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Date and time the article was published
     *
     * @return Calendar Object
     */
    public Calendar getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsHeadline)) return false;

        NewsHeadline that = (NewsHeadline) o;

        if (!date.equals(that.date)) return false;
        if (!headline.equals(that.headline)) return false;
        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + headline.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
