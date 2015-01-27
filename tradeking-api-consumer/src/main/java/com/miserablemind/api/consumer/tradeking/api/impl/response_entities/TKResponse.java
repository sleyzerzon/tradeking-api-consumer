/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.impl.response_entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.miserablemind.api.consumer.tradeking.api.impl.TradeKingModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonRootName("response")
abstract public class TKResponse {

    private Map<String, Object> extraData = new HashMap<String, Object>();

    /**
     * All the extra information that is not captured by instance variables of TKResponse children
     *
     * @param key   data key
     * @param value data value
     */
    @JsonAnySetter
    public void add(String key, Object value) {
        extraData.put(key, value);
    }

    /**
     * For arrays of objects TK returns an array when multiple, but if only one object found, it is not wrapped in array.
     * This method deserializes and wraps that object to array
     *
     * @param className Class Name of the object to de-serialize to
     * @param response  response from TK
     * @param nestedKey Nesting array key
     * @return Array of objects. The user of this class will cast this to accommodate specif needs
     * @throws Exception
     */
    protected Object[] extractArray(Class<? extends Object[]> className, LinkedHashMap response, String nestedKey) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new TradeKingModule());
        mapper.registerModule(new JodaModule());
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        Object nestedEntry = response.get(nestedKey);

        if (nestedEntry.getClass() != ArrayList.class) {
            nestedEntry = new Object[]{nestedEntry};
        }

        String jsonArray = mapper.writeValueAsString(nestedEntry);

        return mapper.readValue(jsonArray, className);

    }

}
