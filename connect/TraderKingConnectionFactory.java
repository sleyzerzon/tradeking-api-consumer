package com.miserablemind.twtbeat.domain.service.traderking.connect;

import com.miserablemind.twtbeat.domain.service.traderking.api.TraderKingOperations;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;

public class TraderKingConnectionFactory extends OAuth1ConnectionFactory<TraderKingOperations> {

  public TraderKingConnectionFactory(String consumerKey, String consumerSecret) {
    super(TraderKingServiceProvider.PROVIDER_ID, new TraderKingServiceProvider(consumerKey, consumerSecret), new TraderKingApiAdapter());
  }


}
