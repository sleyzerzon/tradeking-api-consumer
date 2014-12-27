/*
 * Miserable Mind
 * http://www.miserablemind.com
 * The MIT License (MIT)
 */

package com.miserablemind.api.consumer.tradeking.api.impl;


import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseTemplate {

  private RestTemplate restTemplate;

  BaseTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  private static final String URL_BASE = "https://api.tradeking.com/v1/";

  protected RestTemplate getRestTemplate() {
    return this.restTemplate;
  }

  protected String buildCommaSeparatedParameterValue(String[] parameterValueList) {

    if (null == parameterValueList) return "";

    StringBuilder builder = new StringBuilder();
    List<String> parameters = new ArrayList<String>(Arrays.asList(parameterValueList));
    builder.append(parameters.remove(0));
    for (String parameter : parameters) {
      builder.append(",");
      builder.append(parameter);
    }
    return builder.toString();
  }

  protected URI buildUri(String path) {
    return this.buildUri(path, EMPTY_PARAMETERS);
  }

  protected URI buildUri(String path, String parameterName, String parameterValue) {
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
    parameters.set(parameterName, parameterValue);
    return this.buildUri(path, parameters);
  }

  protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
    return URIBuilder.fromUri(URL_BASE + path).queryParams(parameters).build();
  }

  private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();


}
