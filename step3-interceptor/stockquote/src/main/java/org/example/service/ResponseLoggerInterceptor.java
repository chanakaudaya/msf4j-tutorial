package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.Response;
import org.wso2.msf4j.interceptor.ResponseInterceptor;

/**
 * Class for logging HTTP responses.
 */
public class ResponseLoggerInterceptor implements ResponseInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ResponseLoggerInterceptor.class);

    @Override
    public boolean interceptResponse(Request request, Response response) throws Exception {
        log.info("Logging HTTP response");
        String propertyName = "SampleProperty";
        String property = (String) request.getProperty(propertyName);
        log.info("Value of property {} is {} ", propertyName, property);
        return true;
    }
}