package com.miserablemind.twtbeat.domain.service.traderking.api;

import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TKTransactionHistoryEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.AccountHoldings;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary.AccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.market.StockQuote;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.TKUser;

public interface TraderKingOperations {

  public TKUser getCurrentUser();

  public AccountsSummary[] getAccount();

  public AccountBalance getAccountBalance(String accountId);

  public AccountHoldings getAccountHoldings(String accountId);

  public TKTransactionHistoryEntry[] getAllHistory(String accountId);

  public void updateStatus();

  public StockQuote getQuoteForStock(String ticker);

  public StockQuote[] getQuoteForStocks(String[] tickers);

}
