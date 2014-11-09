package com.miserablemind.twtbeat.domain.service.traderking.api;

import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.history.TKTransactionHistoryEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.holdings.AccountHoldings;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.MarketStatus;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.NewsArticle;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.OptionQuote;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.market.StockQuote;
import com.miserablemind.twtbeat.domain.service.traderking.api.domain.member.TKUser;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.OptionQuoteNotFoundException;

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

  public double[] getStrikePrices(String ticker);

  public Calendar[] getOptionExpirationDates(String ticker);

  public NewsArticle[] getLatestCompanyNews(String ticker, int limit);

  public NewsArticle[] getNewsByKeywords(String[] keywords, int limit);

  public NewsArticle getNewsById(String newsId);

  public MarketStatus getMarketStatus();

}
