/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */


package com.miserablemind.api.consumer.tradeking.api.domain.market;

/**
 * Change Sign for the quote
 */
public enum ChangeSign {
    UP("u"), DOWN("d"), EQUAL("e");
    private String value;

    ChangeSign(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
