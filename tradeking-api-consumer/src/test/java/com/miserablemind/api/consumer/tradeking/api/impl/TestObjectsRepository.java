package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.BuyingPower;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.Cash;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.Securities;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TradeKingTransaction;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TransactionDetails;
import com.miserablemind.api.consumer.tradeking.api.domain.account.history.TransactionSecurity;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.*;
import com.miserablemind.api.consumer.tradeking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.api.consumer.tradeking.api.domain.market.MarketStatus;
import com.miserablemind.api.consumer.tradeking.api.domain.market.TimeSalesQuote;
import com.miserablemind.api.consumer.tradeking.api.domain.member.TradeKingUser;
import com.miserablemind.api.consumer.tradeking.api.domain.member.UserAccount;
import com.miserablemind.api.consumer.tradeking.api.domain.member.UserProfile;
import com.miserablemind.api.consumer.tradeking.api.domain.watchlist.WatchlistItem;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * This is the repository for the objects that are mapped from json files in test
 * resources
 */
public class TestObjectsRepository {

  /*
    Account Template Data
   */
  String accountId = "TestAccount1";
  Cash cash = new Cash(0.0, 9.83, 10.98, 0.0, 0.0, 10.98, 0.0, 0.0, 0.0);
  BuyingPower buyingPower = new BuyingPower(26.63, 100, 26.63, 26.63, 53.26, 53.26);
  Securities securities = new Securities(0.0, 26.48, 0.0, 0.0, 0.0, 26.48, 26.48);

  AccountHoldingEntry accountHoldingEntry1 = new AccountHoldingEntry(AccountHoldingEntry.HoldingType.MARGIN_LONG, 906.87,
    new HoldingDisplayData("Margin", "Stock", "$.00", "$906.87", "SOMETHING 1 CO", "$28.34", "$113,3.00", "-$9.00", 40, "SMTH1"),
    2267.129999999999,
    new FinancialInstrument("300000000", "SOMETHING 1 CO", 0, "CS", "SMTH1"),
    1133.0, -92, 28.34, 22.672175000000003, 40,
    new HoldingsQuote(0, 28.34), 0
  );

  AccountHoldingEntry accountHoldingEntry2 = new AccountHoldingEntry(AccountHoldingEntry.HoldingType.MARGIN_LONG, 580.71,
    new HoldingDisplayData("Margin", "Stock", "$.00", "$580.71", "SOMETHING2 CO", "$348.94", "$593.98", "$124.61", 2, "SMTH2"),
    12.26999999999953,
    new FinancialInstrument("6000L0000", "SOMETHING2 CO", 0, "CS", "SMTH2"),
    593.98, 12.60999999999967, 348.94, 341.5711764705882, 17,
    new HoldingsQuote(0, 348.94), 0
  );

  //todo: figure out if only one holding
  AccountHoldingEntry[] holdingsList = new AccountHoldingEntry[]{accountHoldingEntry1, accountHoldingEntry2};
  AccountBalance balance = new AccountBalance(accountId, 36.46, 0.0, buyingPower, 0.0, 0.0, 26.63, cash, securities);
  AccountHoldings holdings = new AccountHoldings(holdingsList, 26.48);
  AccountsSummary accountsSummary1 = new AccountsSummary(accountId, balance, holdings);

  // Need additional account for testing pulling multiple accounts
  String accountId2 = "TestAccount2";
  AccountBalance balance2 = new AccountBalance(accountId2, 36.46, 0.0, buyingPower, 0.0, 0.0, 26.63, cash, securities);
  AccountsSummary accountsSummary2 = new AccountsSummary(accountId2, balance2, holdings);

  //Transaction1
  Calendar transactionDate1 = new Calendar.Builder()
    .setDate(2014, 11, 15)
    .setTimeZone(TimeZone.getTimeZone("GMT"))
    .setFields(Calendar.HOUR_OF_DAY, 5, Calendar.HOUR, 5)
    .build();

  Calendar settlementDate1 = new Calendar.Builder()
    .setDate(2014, 11, 18)
    .setTimeZone(TimeZone.getTimeZone("GMT"))
    .setFields(Calendar.HOUR_OF_DAY, 5, Calendar.HOUR, 5)
    .build();

  TransactionSecurity security1 = new TransactionSecurity("800000000", "80000000", "CS", "SMTH2");
  TransactionDetails transactionDetails1 = new TransactionDetails(4.95, "SOMETHING INC-DEL", 0, 2.671, -10, "XCH", 2, 2, 0.08, security1, transactionDate1, settlementDate1, 10, null);
  TradeKingTransaction transaction1 = new TradeKingTransaction(TradeKingTransaction.Type.TRADE, 286.07, transactionDate1, "SOMETHING INC", "SMTH2", transactionDetails1);

  //Transaction2
  Calendar transactionDate2 = new Calendar.Builder()
    .setDate(2014, 11, 1)
    .setTimeZone(TimeZone.getTimeZone("GMT"))
    .setFields(Calendar.HOUR_OF_DAY, 5, Calendar.HOUR, 5)
    .build();

  TransactionSecurity security2 = new TransactionSecurity("300000000", "30000000", "CS", "SMTH1");
  TransactionDetails transactionDetails2 = new TransactionDetails(0, "SOMETHING CO CASH DIV  ON     40 SHS ", 0, 0, 0, "DIV", 0, 2, 0, security2, transactionDate2, null, 10, "Cash Dividend");
  TradeKingTransaction transaction2 = new TradeKingTransaction(TradeKingTransaction.Type.DIVIDEND, 24, transactionDate2, "SOMETHING CO,CASH DIV ON 40 SHS", "SMTH1", transactionDetails2);


  /*
  WATCH LISTS
   */
  String[] watchLists = new String[]{"DEFAULT", "watch2"};
  WatchlistItem watchlistItem1 = new WatchlistItem(0, 0, "TCKR1");
  WatchlistItem watchlistItem2 = new WatchlistItem(0, 0, "TCKR2");

  /*
 API Utilities
   */
  String apiVersion = "1.0-RC1";
  UserProfile userProfile = new UserProfile("1000001", "quickQuote", "NAME", "SURNAME", true, true, "name.surname@example.com", "0", true, true, "TestAccount1=05/06/2013");
  UserAccount userAccount = new UserAccount("TestAccount1", true, false, false, "NAME SURNAME", 2, false, true);
  TradeKingUser user = new TradeKingUser(false, false, false, new UserAccount[]{userAccount}, userProfile);

  /*
  Market
   */
  Calendar marketStatusDate = new Calendar.Builder().setDate(2015, 0, 4).setTimeOfDay(18, 16, 59, 999).build();
  MarketStatus marketStatus = new MarketStatus(marketStatusDate, MarketStatus.MarketCondition.CLOSED, MarketStatus.MarketCondition.PRE_OPEN, "08:00:00", "Market is open Monday through Friday 9:30AM to 4:00PM EST", 1420413060);

  Calendar startSalesQuoteTime = new Calendar.Builder()
    .setDate(2015, 0, 2)
    .setTimeZone(TimeZone.getTimeZone("GMT"))
    .setFields(Calendar.AM_PM, 1)
    .setTimeOfDay(9, 37, 0)
    .build();
  Calendar quoteDate = new Calendar.Builder().setDate(2015, 0, 2).setTimeZone(TimeZone.getTimeZone("GMT")).build();
  TimeSalesQuote timeSalesQuote1 = new TimeSalesQuote(quoteDate, startSalesQuoteTime, 111.05, 111.05, 53, 111.05, 111.05, 1420191420, 53);


  Calendar startSalesQuoteTime2 = new Calendar.Builder()
    .setDate(2015, 0, 2)
    .setTimeZone(TimeZone.getTimeZone("GMT"))
    .setFields(Calendar.AM_PM, 1)
    .setTimeOfDay(9, 44, 0)
    .build();
  TimeSalesQuote timeSalesQuote2 = new TimeSalesQuote(quoteDate, startSalesQuoteTime2, 110.95, 110.95, 75, 110.95, 110.95, 1420191840, 75);

}
