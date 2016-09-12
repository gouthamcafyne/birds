/**
 * 
 */
package com.saltside.webapp.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.common.pojo.Bird;
import com.common.pojo.web.BirdRequest;
import com.common.pojo.web.BirdResponse;
import com.saltside.service.bird.IBirdService;

/**
 * @author Goutham P N
 *
 */
@Path("/bird")
@Component
public class BirdControllerAPI {

	@Autowired
	private IBirdService birdService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/birds")
	public BirdResponse getBirds() throws Exception {
		BirdResponse response = new BirdResponse();
		response.setBirds(birdService.getBirds());
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/birds/{id}")
	public BirdResponse getBird(@PathParam("id") String birdId) throws Exception {
		BirdResponse response = new BirdResponse();
		response.getBirds().addItem((birdService.getBird(birdId)));
		return response;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/birds")
	public void addBird(@RequestBody BirdRequest birdRequest) throws Exception {
		Bird bird = new Bird();
		bird.setName(birdRequest.getName());
		bird.setFamily(birdRequest.getFamily());
		bird.setContinents(birdRequest.getContinent());
		birdService.addBird(bird);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/birds/{id}")
	public BirdResponse deleteBird(@PathParam("id") String birdId) throws Exception {
		BirdResponse response = new BirdResponse();
		birdService.deleteBird(birdId);
		return response;
	}
}
