/**
 * 
 */
package com.saltside.service.bird.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.pojo.Bird;
import com.common.pojo.SSBatch;
import com.saltside.persistence.dao.birds.IBirdsDAO;
import com.saltside.service.bird.IBirdService;

/**
 * @author Goutham P N
 *
 */
@Service
public class BirdServiceImpl implements IBirdService {

	@Autowired
	private IBirdsDAO birdsDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#getBirds()
	 */
	public SSBatch<Bird> getBirds() throws Exception {
		SSBatch<Bird> response = new SSBatch<Bird>();
		response.setItems(birdsDAO.fetchAll());
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#getBird(java.lang.String)
	 */
	public Bird getBird(String id) throws Exception {
		return birdsDAO.fetch(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#addBird(com.common.pojo.Bird)
	 */
	public void addBird(Bird bird) throws Exception {
		birdsDAO.add(bird);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#deleteBird(java.lang.String)
	 */
	public Bird deleteBird(String id) throws Exception {
		Bird bird = birdsDAO.fetch(id);
		birdsDAO.delete(id);
		return bird;
	}
}
