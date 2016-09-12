/**
 * 
 */
package com.saltside.service.bird;

import com.common.pojo.Bird;
import com.common.pojo.SSBatch;
import com.saltside.foundation.service.IService;

/**
 * @author Goutham P N
 *
 */
public interface IBirdService extends IService {
	SSBatch<Bird> getBirds() throws Exception;

	Bird getBird(String id) throws Exception;

	void addBird(Bird bird) throws Exception;

	Bird deleteBird(String id) throws Exception;
}
