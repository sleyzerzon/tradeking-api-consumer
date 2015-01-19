/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;


import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Calendar;
import java.util.LinkedHashMap;

public class TKOptionExpirationsResponse extends TKResponse {

    private String error;

    private Calendar[] dates;

    @JsonSetter("expirationdates")
    public void setDates(LinkedHashMap datesResponse) throws Exception {
        this.dates = (Calendar[]) this.extractArray(Calendar[].class, datesResponse, "date", null);
    }

    public String getError() {
        return error;
    }

    public Calendar[] getDates() {
        return dates;
    }
}
