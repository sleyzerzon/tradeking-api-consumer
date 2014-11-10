package com.miserablemind.twtbeat.domain.service.traderking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.NewsArticle;

import java.util.LinkedHashMap;

public class TKNewsArticlesSearchResponse extends TKResponse {

  private String error;

  private NewsArticle[] articles;

  @JsonSetter("articles")
  public void setArticles(LinkedHashMap articlesResponse) throws Exception {
    this.articles = (NewsArticle[]) this.extractArray(NewsArticle[].class, articlesResponse, "article", "MM/dd HH:mm");
  }


  public String getError() {
    return error;
  }

  public NewsArticle[] getArticles() {
    return articles;
  }
}
