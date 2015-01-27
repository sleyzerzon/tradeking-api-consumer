/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;


import org.joda.time.LocalDateTime;

/**
 * News Headline class with story in it
 */
public class NewsStory extends NewsHeadline {
    private String story;

    public NewsStory() {
    }

    public NewsStory(String id, String headline, LocalDateTime date, String story) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsStory)) return false;

        NewsStory newsStory = (NewsStory) o;

        if (!story.equals(newsStory.story)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return story.hashCode();
    }
}
