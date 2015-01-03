package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.BuyingPower;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.Cash;
import com.miserablemind.api.consumer.tradeking.api.domain.account.balance.Securities;
import com.miserablemind.api.consumer.tradeking.api.domain.account.holdings.*;
import com.miserablemind.api.consumer.tradeking.api.domain.account.summary.AccountsSummary;

/**
 * This is the repository for the objects that are mapped from json files in test
 * resources
 */
public class TestObjectsRepository {

  /*
    Account Data
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

  AccountHoldingEntry[] holdingsList = new AccountHoldingEntry[]{accountHoldingEntry1, accountHoldingEntry2};

  AccountBalance balance = new AccountBalance(accountId, 36.46, 0.0, buyingPower, 0.0, 0.0, 26.63, cash, securities);
  //todo: figure out if only one holding
  AccountHoldings holdings = new AccountHoldings(holdingsList, 26.48);
  AccountsSummary accountsSummary1 = new AccountsSummary(accountId, balance, holdings);

}
