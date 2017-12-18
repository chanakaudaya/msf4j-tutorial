package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.Response;
import org.wso2.msf4j.interceptor.RequestInterceptor;


/**
 * Class for logging HTTP requests.
 */
public class RequestLoggerInterceptor implements RequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggerInterceptor.class);

    @Override
    public boolean interceptRequest(Request request, Response response) throws Exception {
        log.info("Logging HTTP request { HTTPMethod: {}, URI: {} }", request.getHttpMethod(), request.getUri());
        String propertyName = "SampleProperty";
        String property = "WSO2-2017";
        request.setProperty(propertyName, property);
        log.info("Property {} with value {} set to request", propertyName, property);
        return true;
    }
}