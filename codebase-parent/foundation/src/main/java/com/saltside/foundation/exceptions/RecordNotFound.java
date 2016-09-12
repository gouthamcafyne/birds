/**
 * 
 */
package com.saltside.foundation.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Goutham P N
 *
 */
@Provider
public class RecordNotFound extends Exception implements ExceptionMapper<RecordNotFound> {
	private static final long serialVersionUID = 1L;

	public RecordNotFound() {
		super("No record found with the given criteria !!");
	}

	public RecordNotFound(String msg) {
		super(msg);
	}

	public Response toResponse(RecordNotFound exception) {
		return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
	}
}
