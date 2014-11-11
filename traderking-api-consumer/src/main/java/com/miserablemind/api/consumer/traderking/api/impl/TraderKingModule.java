/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.traderking.api.impl;


import com.fasterxml.jackson.databind.module.SimpleModule;
import com.miserablemind.api.consumer.traderking.api.domain.TKObject;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.AccountBalance;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.BuyingPower;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.Cash;
import com.miserablemind.api.consumer.traderking.api.domain.account.balance.Securities;
import com.miserablemind.api.consumer.traderking.api.domain.account.history.TKTransactionHistoryEntry;
import com.miserablemind.api.consumer.traderking.api.domain.account.history.TransactionDetails;
import com.miserablemind.api.consumer.traderking.api.domain.account.history.TransactionSecurity;
import com.miserablemind.api.consumer.traderking.api.domain.account.holdings.*;
import com.miserablemind.api.consumer.traderking.api.domain.account.summary.AccountsSummary;
import com.miserablemind.api.consumer.traderking.api.domain.market.*;
import com.miserablemind.api.consumer.traderking.api.domain.member.UserAccount;
import com.miserablemind.api.consumer.traderking.api.impl.mixins.*;


public class TraderKingModule extends SimpleModule {

  public TraderKingModule() {
    super("TraderKingModule");
  }

  @Override
  public void setupModule(SetupContext context) {
    context.setMixInAnnotations(TKObject.class, TKObjectMixIn.class);
    context.setMixInAnnotations(AccountBalance.class, AccountBalanceMixIn.class);
    context.setMixInAnnotations(AccountHoldingEntry.class, AccountHoldingEntryMixIn.class);
    context.setMixInAnnotations(AccountHoldings.class, AccountHoldingsMixIn.class);
    context.setMixInAnnotations(BuyingPower.class, BuyingPowerMixIn.class);
    context.setMixInAnnotations(FinancialInstrument.class, FinancialInstrumentMixIn.class);
    context.setMixInAnnotations(HoldingDisplayData.class, HoldingDisplayDataMixIn.class);
    context.setMixInAnnotations(OptionQuote.class, OptionQuoteMixIn.class);
    context.setMixInAnnotations(HoldingsQuote.class, HoldingQuoteMixIn.class);
    context.setMixInAnnotations(Securities.class, SecuritiesMixIn.class);
    context.setMixInAnnotations(StockQuote.class, StockQuoteMixin.class);
    context.setMixInAnnotations(AccountsSummary.class, TKAllAccountsSummaryMixIn.class);
    context.setMixInAnnotations(TKTransactionHistoryEntry.class, TKTransactionHistoryEntryMixIn.class);
    context.setMixInAnnotations(TransactionDetails.class, TransactionDetailsMixIn.class);
    context.setMixInAnnotations(TransactionSecurity.class, TransactionSecurityMixIn.class);
    context.setMixInAnnotations(UserAccount.class, UserAccountMixIn.class);
    context.setMixInAnnotations(Cash.class, CashMixIn.class);
    context.setMixInAnnotations(NewsArticle.class, NewsArticleMixIn.class);
    context.setMixInAnnotations(TopListEntry.class, TopListEntryMixIn.class);
    context.setMixInAnnotations(TimeSalesQuote.class, TimeSalesQuoteMixIn.class);
  }


}
