package org.acsousa.resources.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acsousa.resources.dto.ErrorResponse;
import org.jboss.resteasy.reactive.RestResponse;

@Provider
public class IllegalStateExceptionMapper implements ExceptionMapper<IllegalStateException> {

    @Override
    public Response toResponse(IllegalStateException exception) {
        ErrorResponse errorResponse = new ErrorResponse("BAD_REQUEST", exception.getMessage());
        return RestResponse.status(RestResponse.Status.BAD_REQUEST, errorResponse).toResponse();
    }
}
