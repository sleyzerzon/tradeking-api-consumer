package com.miserablemind.twtbeat.domain.service.traderking.api.pojos.account.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miserablemind.twtbeat.domain.service.traderking.api.pojos.TKObject;

import java.util.Date;

public class OptionQuote extends TKObject {

  public static final char CHANGE_SIGN_UP = 'u';
  public static final char CHANGE_SIGN_DOWN = 'd';
  public static final char CHANGE_SIGN_EQUAL = 'e';

  public static final char OPTION_DELIVERY_STANDARD = 'S';
  public static final char OPTION_DELIVERY_NON_STANDARD = 'N';
  public static final char OPTION_DELIVERY_UNSPECIFIED = 'X';

  public static final char OPTION_STYLE_AMERICAN = 'A';
  public static final char OPTION_STYLE_EUROPEAN = 'E';

  public static final int OPTION_CLASS_STANDARD = 0;
  public static final int OPTION_CLASS_LEAP = 1;
  public static final int OPTION_CLASS_SHORT_TERM = 2;

  public static final String OPTION_TYPE_PUT = "put";
  public static final String OPTION_TYPE_CALL = "call";


  private double ask;

  @JsonProperty("ask_time")
  private String askTime;

  @JsonProperty("asksz")
  private int askLatestSize;

  private int basis;

  private double bid;

  @JsonProperty("bid_time")
  private String bidTime;

  @JsonProperty("bidsz")
  private int bidLatestSize;

  @JsonProperty("chg")
  private double change;

  @JsonProperty("chg_sign")
  private char changeSign;

  @JsonProperty("chg_t")
  private String changeText;

  @JsonProperty("cl")
  private double previousClose;

  @JsonProperty("contract_size")
  private int contract_size;

  @JsonProperty("date")
  private Date dateLastTrade;

  @JsonProperty("date_time")
  private Date timeLastTrade;

  @JsonProperty("days_to_expiration")
  private int daystToExparation;

  @JsonProperty("exch")
  private String exchangeCode;

  @JsonProperty("exch_desc")
  private String exchangeDescription;

  @JsonProperty("hi")
  private double dayHigh;

  @JsonProperty("incr_vl")
  private int volumeLastTrade;

  @JsonProperty("issue_desc")
  private String fullDescription;

  @JsonProperty("last")
  private double lastPrice;

  @JsonProperty("lo")
  private double dayLow;

  @JsonProperty("op_delivery")
  private char optionDelivery;

  @JsonProperty("op_flag")
  private boolean hasOptions;

  @JsonProperty("op_style")
  private char optionStyle;

  @JsonProperty("op_subclass")
  private int optionClass;

  @JsonProperty("op_subclass")
  private double openTradePrice;

  @JsonProperty("pchg")
  private String changePercentage;

  @JsonProperty("pchg_sign")
  private String changePercentageSign;

  @JsonProperty("pcls")
  private double priorDayClose;

  @JsonProperty("phi")
  private double priorDayHigh;

  @JsonProperty("plo")
  private double priorDayLow;

  @JsonProperty("popn")
  private double priorDayOpen;

  //todo: Int?
  @JsonProperty("pr_openinterest")
  private String priorDayOpenInterest;

  @JsonProperty("prchg")
  private double priorDayChange;

  @JsonProperty("prem_mult")
  private double optionPremiumMultiplier;

  @JsonProperty("put_call")
  private String optionType;

}

