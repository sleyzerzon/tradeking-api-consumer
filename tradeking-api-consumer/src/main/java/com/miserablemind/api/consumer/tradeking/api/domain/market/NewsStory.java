/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;


import java.util.Calendar;

/**
 * News Headline class with story in it
 */
public class NewsStory extends NewsHeadline {
    private String story;

    NewsStory(String id, String headline, Calendar date, String story) {
        super(id, headline, date);
        this.story = story;
    }

    /**
     * the body text of the Article
     *
     * @return Text of article
     */
    public String getStory() {
        return story;
    }
}
