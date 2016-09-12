package com.saltside.foundation.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

@Provider
public class UnknownException extends Throwable implements ExceptionMapper<Throwable> {
	private static final Logger _logger = Logger.getLogger(UnknownException.class);
	private static final long serialVersionUID = 1L;

	public Response toResponse(Throwable exception) {
		_logger.error(exception.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Something bad happened. Please try again !!")
				.type(MediaType.TEXT_PLAIN).build();
	}
}
