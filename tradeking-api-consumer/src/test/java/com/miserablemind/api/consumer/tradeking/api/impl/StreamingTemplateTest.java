package com.miserablemind.api.consumer.tradeking.api.impl;


import com.miserablemind.api.consumer.tradeking.api.StreamListener;
import com.miserablemind.api.consumer.tradeking.api.domain.market.StreamQuoteEvent;
import com.miserablemind.api.consumer.tradeking.api.domain.market.StreamTradeEvent;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class StreamingTemplateTest extends BaseTemplateTest {

    Boolean quoteAssertionPassed = null;
    Boolean tradeAssertionPassed = null;

    @Test
    public void quotesAndTradesStream_testQuote() throws InterruptedException {

        mockServer.expect(requestTo(StreamingTemplate.URL_STREAM_QUOTES_TRADES))
                .andExpect(method(POST))
                .andExpect(content().string("symbols=CMPN1"))
                .andRespond(withSuccess(jsonResource("market/stream_quote"), MediaType.APPLICATION_JSON));

        ArrayList<StreamListener> listeners = new ArrayList<>();
        listeners.add(new TestListener());

        Stream stream = tradeKing.getStreamingOperations().quotesAndTradesStream(listeners, new String[]{"CMPN1"});

        Thread.sleep(2000); // delay while stream is read

        mockServer.verify();

        queryForStatus("Quote", quoteAssertionPassed);

        stream.close();

    }

    @Test
    public void quotesAndTradesStream_testTrade() throws InterruptedException {

        mockServer.expect(requestTo(StreamingTemplate.URL_STREAM_QUOTES_TRADES))
                .andExpect(method(POST))
                .andExpect(content().string("symbols=CMPN1"))
                .andRespond(withSuccess(jsonResource("market/stream_trade"), MediaType.APPLICATION_JSON));

        ArrayList<StreamListener> listeners = new ArrayList<>();
        listeners.add(new TestListener());

        tradeKing.getStreamingOperations().quotesAndTradesStream(listeners, new String[]{"CMPN1"});

        Thread.sleep(2000); // delay while stream is read

        mockServer.verify();

        queryForStatus("Quote", tradeAssertionPassed);

    }

    private void queryForStatus(String description, Boolean varToCheck) throws InterruptedException {
        int timesQueried = 0;

        while (true) {

            if (timesQueried > 100) {
                assertFalse("Timeout checking the " + description + " match", true);
                break;
            }

            if (null == varToCheck) {
                timesQueried++;
                Thread.sleep(200);
            } else if (varToCheck) {
                break;
            } else {
                assertFalse("Stream " + description + " do not match", true);
            }

        }
    }


    class TestListener implements StreamListener {

        @Override
        public void onTrade(StreamTradeEvent tradeEvent) {
            tradeAssertionPassed = tradeEvent.equals(mockData.streamTrade);
        }

        @Override
        public void onQuote(StreamQuoteEvent quoteEvent) {
            quoteAssertionPassed = quoteEvent.equals(mockData.streamQuote);
        }
    }
}
