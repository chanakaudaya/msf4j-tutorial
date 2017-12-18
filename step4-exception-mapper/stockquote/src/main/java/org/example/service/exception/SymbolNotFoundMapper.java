package org.example.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * ExceptionMapper which handled SymbolNotFoundException.
 */
public class SymbolNotFoundMapper implements ExceptionMapper<SymbolNotFoundException> {

    public Response toResponse(SymbolNotFoundException ex) {
        return Response.status(404).
                entity(ex.getMessage() + " [from SymbolNotFoundMapper]").
                type("text/plain").
                build();
    }
}