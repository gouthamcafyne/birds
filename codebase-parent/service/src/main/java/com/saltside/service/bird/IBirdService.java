/**
 * 
 */
package com.saltside.service.bird;

import java.util.List;

import com.common.pojo.Bird;
import com.saltside.foundation.service.IService;

/**
 * @author Goutham P N
 *
 */
public interface IBirdService extends IService {
	List<Bird> getBirds() throws Exception;

	Bird getBird(String id) throws Exception;

	void addBird(Bird bird) throws Exception;

	Bird deleteBird(String id) throws Exception;
}
