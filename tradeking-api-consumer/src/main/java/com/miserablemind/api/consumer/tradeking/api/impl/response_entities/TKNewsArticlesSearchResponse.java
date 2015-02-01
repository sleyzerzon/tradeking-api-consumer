/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.api.consumer.tradeking.api.domain.market.NewsHeadline;

import java.util.LinkedHashMap;

public class TKNewsArticlesSearchResponse extends TKResponse {

    private String error;

    private NewsHeadline[] articles;

    @JsonSetter("articles")
    public void setArticles(LinkedHashMap articlesResponse) throws Exception {
        this.articles = (NewsHeadline[]) this.extractArray(NewsHeadline[].class, articlesResponse, "article");
    }


    public String getError() {
        return error;
    }

    public NewsHeadline[] getArticles() {
        return articles;
    }
}
