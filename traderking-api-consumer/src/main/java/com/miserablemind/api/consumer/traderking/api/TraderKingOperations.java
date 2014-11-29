/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.traderking.api;

import com.miserablemind.api.consumer.traderking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.traderking.api.domain.account.history.TKTransactionHistoryEntry;
import com.miserablemind.api.consumer.traderking.api.domain.account.holdings.AccountHoldings;
import com.miserablemind.api.consumer.traderking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.api.consumer.traderking.api.domain.market.*;
import com.miserablemind.api.consumer.traderking.api.domain.member.TKUser;
import com.miserablemind.api.consumer.traderking.api.impl.OptionQuoteNotFoundException;

import java.util.Calendar;

public interface TraderKingOperations {

  public TKUser getCurrentUser();

  public AccountsSummary[] getAccount();

  public AccountBalance getAccountBalance(String accountId);

  public AccountHoldings getAccountHoldings(String accountId);

  public TKTransactionHistoryEntry[] getAllHistory(String accountId);

  public void updateStatus();

  public StockQuote getQuoteForStock(String ticker);

  public StockQuote[] getQuoteForStocks(String[] tickers);

  public OptionQuote getQuoteForOption(String ticker, Calendar expirationDate, OptionQuote.OptionType type, double strikePrice) throws OptionQuoteNotFoundException;

  public OptionQuote[] searchOptions(String ticker, Double minStrikePrice, Double maxStrikePrice, OptionQuote.OptionType type, Calendar startDate, Calendar endDate);

  public Double[] getStrikePrices(String ticker);

  public Calendar[] getOptionExpirationDates(String ticker);

  public NewsArticle[] getNewsList(String ticker, int limit);

  public NewsArticle[] getNewsList(String[] keywords, int limit);

  public NewsArticle getNewsById(String newsId);

  public MarketStatus getMarketStatus();

  public TopListEntry[] getTopList(TopListEntry.ListType listType);

  public TimeSalesQuote[] getDataPoints(String ticker, int pageNumber, int perPage);

  public TimeSalesQuote[] getDataPoints(String ticker, Calendar startDate, Calendar endDate, TimeSalesQuote.Interval interval);



}
