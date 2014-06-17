package com.miserablemind.twtbeat.domain.service.traderking.connect;

import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import com.miserablemind.twtbeat.domain.service.traderking.api.impl.TraderKingTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;

public class TraderKingServiceProvider extends AbstractOAuth1ServiceProvider<TraderKingOperations> {

  public final static String PROVIDER_ID = "traderking";

  public TraderKingServiceProvider(String consumerKey, String consumerSecret) {
    super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
            "https://developers.tradeking.com/oauth/request_token",
            "https://developers.tradeking.com/oauth/authorize",
            "https://developers.tradeking.com/oauth/access_token"
    ));
  }

  @Override
  public TraderKingOperations getApi(String accessToken, String secret) {
    return new TraderKingTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
  }
}
