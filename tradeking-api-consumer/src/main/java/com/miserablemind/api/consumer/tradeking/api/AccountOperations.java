/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api;

import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TKTransactionHistoryEntry;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.AccountHoldings;
import com.miserablemind.api.consumer.tradeking.api.domain.account.summary.AccountsSummary;

public interface AccountOperations {

  public AccountsSummary[] getAccount();

  public AccountBalance getAccountBalance(String accountId);

  public AccountHoldings getAccountHoldings(String accountId);

  public TKTransactionHistoryEntry[] getAllHistory(String accountId);

  public void updateStatus();


}
