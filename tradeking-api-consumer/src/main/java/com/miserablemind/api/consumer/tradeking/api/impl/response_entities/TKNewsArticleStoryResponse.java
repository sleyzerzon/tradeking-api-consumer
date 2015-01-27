/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.miserablemind.api.consumer.tradeking.api.domain.market.NewsStory;
import com.miserablemind.api.consumer.tradeking.api.impl.TradeKingModule;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.LinkedHashMap;

public class TKNewsArticleStoryResponse extends TKResponse {

    private String error;

    private NewsStory article;

    @JsonSetter("article")
    public void setArticle(LinkedHashMap articlesResponse) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new TradeKingModule());
        mapper.registerModule(new JodaModule());

        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd HH:mm");
        LocalDateTime date = LocalDateTime.parse((String) articlesResponse.get("date"), formatter);

        this.article = new NewsStory(
                (String) articlesResponse.get("id"),
                (String) articlesResponse.get("headline"),
                date,
                (String) articlesResponse.get("story")
        );
    }

    public String getError() {
        return error;
    }

    public NewsStory getArticle() {
        return article;
    }

}
