/*
 * Miserable Mind
 * http://www.miserablemind.com | Twitter: @lrimkus
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain;


import java.util.HashMap;
import java.util.Map;

/**
 * Parent TradeKing domain class, that all the other domain classes extend
 */
abstract public class TradeKingObject {

    private Map<String, Object> extraData = new HashMap<String, Object>();

    /**
     * Adds all the additional values to an extraData instance var that do not have a field in the class.
     * Mostly used for Jackson to put all the extra data found in JSON
     *
     * @param key   key of the extra property
     * @param value extra property value
     */
    public void add(String key, Object value) {
        extraData.put(key, value);
    }

}
