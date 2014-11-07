package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.NewsArticle;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingModule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TKNewsArticlesSearchResponse extends TKResponse {

  private String error;

  private NewsArticle[] articles;

  @JsonSetter("articles")
  public void setArticles(LinkedHashMap articlesResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();

    //messed up, all the news will be 1970 for now
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");

    mapper.setDateFormat(dateFormat);
    mapper.registerModule(new TraderKingModule());

    Object articlesContainer = articlesResponse.get("article");
    String jsonArray = mapper.writeValueAsString(articlesContainer);

    //API returns list if multiple article objects, but an article object if only one. Standardize here.
    if (articlesContainer.getClass() == ArrayList.class)
      this.articles = mapper.readValue(jsonArray, NewsArticle[].class);
    else this.articles = new NewsArticle[]{mapper.readValue(jsonArray, NewsArticle.class)};
  }


  public String getError() {
    return error;
  }

  public NewsArticle[] getArticles() {
    return articles;
  }
}
