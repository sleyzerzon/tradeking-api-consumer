package com.miserablemind.twtbeat.domain.service.traderking.api.impl;


import com.fasterxml.jackson.databind.module.SimpleModule;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.mixins.*;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.AccountBalance;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.BuyingPower;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.balance.Securities;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TKTransactionHistoryEntry;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TransactionDetails;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.history.TransactionSecurity;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.holdings.*;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.summary.AccountsSummary;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.market.OptionQuote;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.market.StockQuote;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.TKUser;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.member.UserAccount;

public class TraderKingModule extends SimpleModule {

  public TraderKingModule() {
    super("TraderKingModule");
  }

  @Override
  public void setupModule(SetupContext context) {
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
    context.setMixInAnnotations(TKUser.class, TKUserMixIn.class);
    context.setMixInAnnotations(TransactionDetails.class, TransactionDetailsMixIn.class);
    context.setMixInAnnotations(TransactionSecurity.class, TransactionSecurityMixIn.class);
    context.setMixInAnnotations(UserAccount.class, UserAccountMixIn.class);
  }


}
