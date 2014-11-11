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

package com.miserablemind.api.consumer.traderking.connect;


import com.miserablemind.api.consumer.traderking.api.TraderKingOperations;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;

public class TraderKingConnectionFactory extends OAuth1ConnectionFactory<TraderKingOperations> {

  public TraderKingConnectionFactory(String consumerKey, String consumerSecret) {
    super(TraderKingServiceProvider.PROVIDER_ID, new TraderKingServiceProvider(consumerKey, consumerSecret), new TraderKingApiAdapter());
  }


}
