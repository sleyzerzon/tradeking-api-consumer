package com.miserablemind.api.consumer.traderking.api.domain.market;

import com.miserablemind.api.consumer.traderking.api.domain.TKObject;

import java.util.Calendar;


public class NewsArticle extends TKObject {
  private String id;
  private String headline;
  private String story;
  private Calendar date;

  public NewsArticle() {
  }

  public NewsArticle(String id, String headline, String story, Calendar date) {
    this.id = id;
    this.headline = headline;
    this.story = story;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public String getStory() {
    return story;
  }

  public void setStory(String story) {
    this.story = story;
  }

  public Calendar getDate() {
    return date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }
}
