package com.saltside.foundation.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnknownException extends Throwable implements ExceptionMapper<Throwable> {
	private static final long serialVersionUID = 1L;

	public Response toResponse(Throwable exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Something bad happened. Please try again !!")
				.type(MediaType.TEXT_PLAIN).build();
	}
}
