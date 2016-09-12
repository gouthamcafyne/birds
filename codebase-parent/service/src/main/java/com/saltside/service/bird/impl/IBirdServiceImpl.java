/**
 * 
 */
package com.saltside.service.bird.impl;

import org.jvnet.hk2.annotations.Service;

import com.common.pojo.Bird;
import com.common.pojo.SSBatch;
import com.saltside.service.bird.IBirdService;

/**
 * @author Goutham P N
 *
 */
@Service
public class IBirdServiceImpl implements IBirdService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#getBirds()
	 */
	public SSBatch<Bird> getBirds() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#getBird(java.lang.String)
	 */
	public Bird getBird(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#addBird(com.common.pojo.Bird)
	 */
	public void addBird(Bird bird) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.service.bird.IBirdService#deleteBird(java.lang.String)
	 */
	public Bird deleteBird(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
