/**
 * 
 */
package com.saltside.webapp.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.common.filters.BirdFilter;
import com.common.pojo.Bird;
import com.common.pojo.web.BirdRequest;
import com.common.pojo.web.BirdResponse;
import com.saltside.foundation.exceptions.RecordNotFound;
import com.saltside.service.bird.IBirdService;

/**
 * @author Goutham P N
 *
 */
@Path("/bird")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class BirdControllerAPI {

	@Autowired
	private IBirdService birdService;

	@Autowired
	private BirdFilter birdFilter;

	@GET
	@Path("/birds")
	public Response getBirds() throws Exception {
		BirdResponse response = new BirdResponse();
		List<Bird> birds = birdService.getBirds();
		if (CollectionUtils.isNotEmpty(birds)) {
			response.setBirds(birdFilter.filterVisibleData(birds));
			return Response.ok(response).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("/birds/{id}")
	public Response getBird(@PathParam("id") String birdId) throws Exception {
		BirdResponse response = new BirdResponse();
		Bird bird = birdService.getBird(birdId);
		if (null != bird) {
			if (null != bird.getVisible() && bird.getVisible())
				response.getBirds().addItem(bird);
			return Response.ok(response).build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/birds")
	public Response addBird(@RequestBody BirdRequest birdRequest) throws Exception {
		try {
			Bird bird = new Bird();
			bird.setId(birdRequest.getId());
			bird.setName(birdRequest.getName());
			bird.setFamily(birdRequest.getFamily());
			bird.setContinents(birdRequest.getContinent());
			bird.setVisible(birdRequest.getVisible());
			birdService.addBird(bird);
		} catch (Exception ex) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("/birds/{id}")
	public Response deleteBird(@PathParam("id") String birdId) throws Exception {
		try {
			birdService.deleteBird(birdId);
		} catch (RecordNotFound ex) {
			throw ex;
		} catch (Exception ex) {
			Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Status.OK).build();
	}
}
