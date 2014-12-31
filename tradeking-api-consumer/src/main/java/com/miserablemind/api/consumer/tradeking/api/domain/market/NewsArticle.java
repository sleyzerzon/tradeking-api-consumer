/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

import java.util.Calendar;

/**
 * News Article.
 * todo: make another one extending this one
 */
public class NewsArticle extends TradeKingObject {
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

  /**
   * Article id used for article retrieval
   *
   * @return String article id
   */
  public String getId() {
    return id;
  }

  /**
   * The title of the article
   *
   * @return String headline
   */
  public String getHeadline() {
    return headline;
  }

  /**
   * the body text of the Article
   *
   * @return Text of article if full story is pulled, otherwise null
   */
  public String getStory() {
    return story;
  }

  /**
   * Date and time the article was published
   *
   * @return Calendar Object
   */
  public Calendar getDate() {
    return date;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public void setStory(String story) {
    this.story = story;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }
}
