/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.member;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

/**
 * This is a part of TradeKingUser object that holds data about a trading account. There can ca be multiple trading
 * accounts for user, so UserAccount objects usually go in a list
 */
public class UserAccount extends TradeKingObject {

  private String accountId;
  private boolean fundTrading;
  private boolean ira;
  private boolean marginTrading;
  private String nickName;
  private int optionLevel;
  private boolean shared;
  private boolean stockTrading;

  public UserAccount() {
  }

  public UserAccount(String accountId, boolean fundTrading, boolean ira, boolean marginTrading, String nickName, int optionLevel, boolean shared, boolean stockTrading) {
    this.accountId = accountId;
    this.fundTrading = fundTrading;
    this.ira = ira;
    this.marginTrading = marginTrading;
    this.nickName = nickName;
    this.optionLevel = optionLevel;
    this.shared = shared;
    this.stockTrading = stockTrading;
  }

  /**
   * @return String Id for account
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets Fund Trading flag for an account.
   *
   * @return {@code True} if account is Fund Trading, otherwise {@code False}
   */
  public boolean isFundTrading() {
    return fundTrading;
  }

  /**
   * @return {@code True} if account is IRA, otherwise {@code False}
   */
  public boolean isIra() {
    return ira;
  }

  /**
   * @return {@code True} if account Margin Trading is enabled, otherwise {@code False}
   */
  public boolean isMarginTrading() {
    return marginTrading;
  }

  /**
   * Account Nick Name. By default it is First name Last name
   *
   * @return account nick name
   */
  public String getNickName() {
    return nickName;
  }

  /**
   * @return Option level available for the account
   */
  public int getOptionLevel() {
    return optionLevel;
  }

  /**
   * @return {@code True} if account is shared, otherwise {@code False}
   */
  public boolean isShared() {
    return shared;
  }

  /**
   * @return {@code True} if account is stock trading, otherwise {@code False}
   */
  public boolean isStockTrading() {
    return stockTrading;
  }
}
