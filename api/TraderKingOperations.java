package com.miserablemind.twtbeat.domain.service.traderking.api;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TransactionHistory;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary.TKAllAccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.TKUser;

public interface TraderKingOperations {

  public TKUser getCurrentUser();

  public TKAllAccountsSummary getAccount();

  public AccountBalance getAccountBalance(String accountId);

  public AccountHoldings getAccountHoldings(String accountId);

  public TransactionHistory getAllHistory(String accountId);

  public void updateStatus();

}
