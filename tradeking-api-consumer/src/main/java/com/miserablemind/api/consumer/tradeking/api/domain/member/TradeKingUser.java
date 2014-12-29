/*
 * Miserable Mind | Laurynas Rimkus | Twitter: @lrimkus
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.member;

import com.miserablemind.api.consumer.tradeking.api.domain.TradeKingObject;

//todo: remove spring bs for retrieving user info right away

/**
 * Trade King user object, that is usually used to retrieve authenticated user data
 */
public class TradeKingUser extends TradeKingObject {

  private boolean disabled;
  private boolean resetPassword;
  private boolean resetTradingPassword;
  private UserAccount[] accounts;
  private UserProfile userProfile;

  public TradeKingUser() {
  }

  public TradeKingUser(boolean disabled, boolean resetPassword, boolean resetTradingPassword, UserAccount[] accounts, UserProfile userProfile) {
    this.disabled = disabled;
    this.resetPassword = resetPassword;
    this.resetTradingPassword = resetTradingPassword;
    this.accounts = accounts;
    this.userProfile = userProfile;
  }

  /**
   * Gets all accounts metadata associated with the user
   *
   * @return list of user account objects that holds meta data about user's account
   */
  public UserAccount[] getAccounts() {
    return accounts;
  }

  /**
   * @return {@code True} if user is disabled, else {@code False}
   */
  public boolean isDisabled() {
    return disabled;
  }

  /**
   * Retrieves the Reset User Password flag.
   * This property must be there for updating user to set a flag to reset the password. However, currently API does not provide
   * such functionality
   *
   * @return {@code True} if reset password flag is ON, else {@code False}
   */
  public boolean isResetPassword() {
    return resetPassword;
  }

  /**
   * Retrieves the Reset User Trading Password flag.
   * This property must be there for updating user to set a flag to reset the trading password. However, currently API does not provide
   * such functionality
   *
   * @return {@code True} if reset trading password flag is ON, else {@code False}
   */
  public boolean isResetTradingPassword() {
    return resetTradingPassword;
  }

  /**
   * Gets User Profile Object that has data about the user as a person, like first name, has new message etc..
   *
   * @return User profile object
   */
  public UserProfile getUserProfile() {
    return userProfile;
  }

}
