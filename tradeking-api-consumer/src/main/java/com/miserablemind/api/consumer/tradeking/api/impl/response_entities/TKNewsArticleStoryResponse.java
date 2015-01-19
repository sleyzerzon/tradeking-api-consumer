/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.api.consumer.tradeking.api.domain.market.NewsStory;
import com.miserablemind.api.consumer.tradeking.api.impl.TradeKingModule;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public class TKNewsArticleStoryResponse extends TKResponse {

    private String error;

    private NewsStory article;

    @JsonSetter("article")
    public void setArticle(LinkedHashMap articlesResponse) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //messed up, all the news will be 1970 for now
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");

        mapper.setDateFormat(dateFormat);
        mapper.registerModule(new TradeKingModule());

        this.article = mapper.readValue(mapper.writeValueAsString(articlesResponse), NewsStory.class);
    }

    public String getError() {
        return error;
    }

    public NewsStory getArticle() {
        return article;
    }

}
