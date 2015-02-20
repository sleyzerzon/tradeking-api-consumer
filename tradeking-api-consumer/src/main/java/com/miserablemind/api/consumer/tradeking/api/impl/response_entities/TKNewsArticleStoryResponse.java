/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.api.consumer.tradeking.api.domain.market.NewsStory;

public class TKNewsArticleStoryResponse extends TKResponse {

    private String error;

    @JsonProperty("article")
    private NewsStory article;

    public String getError() {
        return error;
    }

    public NewsStory getArticle() {
        return article;
    }

}
