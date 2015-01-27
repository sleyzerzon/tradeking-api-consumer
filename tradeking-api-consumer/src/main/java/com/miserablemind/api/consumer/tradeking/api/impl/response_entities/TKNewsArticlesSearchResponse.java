/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.miserablemind.api.consumer.tradeking.api.domain.market.NewsHeadline;
import com.miserablemind.api.consumer.tradeking.api.impl.TradeKingModule;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class TKNewsArticlesSearchResponse extends TKResponse {

    private String error;

    private NewsHeadline[] articles;

    @JsonSetter("articles")
    public void setArticles(LinkedHashMap articlesResponse) throws Exception {

        ArrayList<NewsHeadline> headlines = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new TradeKingModule());
        mapper.registerModule(new JodaModule());

        ArrayList<LinkedHashMap> entries = new ArrayList<>();

        if (articlesResponse.get("article").getClass() != ArrayList.class) {
            entries.add((LinkedHashMap) articlesResponse.get("article"));
        } else {
            entries = (ArrayList<LinkedHashMap>) articlesResponse.get("article");
        }

        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd HH:mm");

        headlines.addAll(entries.stream().map(article -> new NewsHeadline(
                (String) article.get("id"),
                (String) article.get("headline"),
                LocalDateTime.parse((String) article.get("date"), formatter)
        )).collect(Collectors.toList()));

        this.articles = new NewsHeadline[headlines.size()];
        this.articles = headlines.toArray(this.articles);
    }


    public String getError() {
        return error;
    }

    public NewsHeadline[] getArticles() {
        return articles;
    }
}
