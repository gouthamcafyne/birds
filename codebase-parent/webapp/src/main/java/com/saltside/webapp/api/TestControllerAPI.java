/**
 * 
 */
package com.saltside.webapp.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 * @author Goutham P N
 *
 */
@Path("/test")
@Component
public class TestControllerAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public String test() {
		return "Sucess!!!";
	}
}
