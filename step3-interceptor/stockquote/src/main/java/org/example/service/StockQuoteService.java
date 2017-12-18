/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.service;

import org.wso2.msf4j.interceptor.annotation.RequestInterceptor;
import org.wso2.msf4j.interceptor.annotation.ResponseInterceptor;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 *
 *  Create = PUT with a new URI
       POST to a base URI returning a newly created URI

    Read   = GET
    Update = PUT with an existing URI
    Delete = DELETE
 */
@Path("/stockquote")
public class StockQuoteService {

    private Map<String, Stock> quotes = new HashMap<>();

    public StockQuoteService() {
        quotes.put("IBM", new Stock("IBM", "IBM Inc.", 90.87, 89.77));
    }

    @GET
    @Path("/{symbol}")
    @Produces("application/json")
    @RequestInterceptor(RequestLoggerInterceptor.class)
    @ResponseInterceptor(ResponseLoggerInterceptor.class)
    public Response get(@PathParam("symbol") String symbol) {
        Stock stock = quotes.get(symbol);
        return stock == null ?
                Response.status(Response.Status.NOT_FOUND).build() :
                Response.status(Response.Status.OK).entity(stock).build();
    }

    // curl -v -X POST -H "Content-Type:application/json" -d '{"symbol":"GOOG","name":"Google Inc.", "high":190.23, "low":187.45}' http://localhost:8080/stockquote
    @POST
    @Consumes("application/json")
    public Response addStock(Stock stock) {
        if(quotes.get(stock.getSymbol()) != null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        quotes.put(stock.getSymbol(), stock);
        return Response.status(Response.Status.OK).
                entity("http://localhost:8080/stockquote/" + stock.getSymbol()).build();
    }

    @PUT
    @Path("/")
    public void put() {
        // TODO: Left as an exercise
        System.out.println("PUT invoked");
    }

    @DELETE
    @Path("/")
    public void delete() {
        // TODO: Left as an exercise
        System.out.println("DELETE invoked");
    }
}
