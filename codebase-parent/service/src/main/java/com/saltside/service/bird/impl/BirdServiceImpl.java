/**
 * 
 */
package com.saltside.service.bird.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.pojo.Bird;
import com.common.pojo.SSBatch;
import com.saltside.foundation.exceptions.RecordNotFound;
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
	public List<Bird> getBirds() throws Exception {
		return birdsDAO.fetchAll();
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
		if (null == bird.getVisible()) {
			bird.setVisible(true);
		}
		bird.setAdded(new Date().toGMTString());
		birdsDAO.add(bird);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#deleteBird(java.lang.String)
	 */
	public Bird deleteBird(String id) throws Exception {
		Bird bird = birdsDAO.fetch(id);
		if (null == bird) {
			throw new RecordNotFound("Data not found");
		}
		birdsDAO.delete(id);
		return bird;
	}
}
