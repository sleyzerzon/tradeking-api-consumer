package com.miserablemind.twtbeat.domain.service.traderking.api.domain.market;

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
