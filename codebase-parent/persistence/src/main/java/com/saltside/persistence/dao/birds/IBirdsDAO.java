/**
 * 
 */
package com.saltside.persistence.dao.birds;

import java.util.List;

import com.common.pojo.Bird;

/**
 * @author Goutham P N
 *
 */
public interface IBirdsDAO {
	List<Bird> fetchAll() throws Exception;

	Bird fetch(String id) throws Exception;

	void add(Bird bird) throws Exception;

	void delete(String id) throws Exception;
}
