/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miserablemind.api.consumer.traderking.api.domain.market.NewsArticle;
import com.miserablemind.api.consumer.traderking.api.impl.TraderKingModule;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public class TKNewsArticleGetResponse extends TKResponse {

  private String error;

  private NewsArticle article;

  @JsonSetter("article")
  public void setArticle(LinkedHashMap articlesResponse) throws Exception {

    ObjectMapper mapper = new ObjectMapper();

    //messed up, all the news will be 1970 for now
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");

    mapper.setDateFormat(dateFormat);
    mapper.registerModule(new TraderKingModule());

    this.article = mapper.readValue(mapper.writeValueAsString(articlesResponse), NewsArticle.class);
  }

  public String getError() {
    return error;
  }

  public NewsArticle getArticle() {
    return article;
  }

}
