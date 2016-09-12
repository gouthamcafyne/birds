/**
 * 
 */
package com.saltside.persistence.dao.birds.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.common.pojo.Bird;
import com.common.pojo.enums.MongoCollections;
import com.saltside.persistence.dao.birds.IBirdsDAO;

/**
 * @author Goutham P N
 *
 */
@Repository
public class BridsDAOImpl implements IBirdsDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.persistence.dao.birds.IBirdsDAO#fetchAll()
	 */
	public List<Bird> fetchAll() throws Exception {
		return mongoTemplate.findAll(Bird.class, MongoCollections.BIRDS.getStrcode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saltside.persistence.dao.birds.IBirdsDAO#fetch(java.lang.String)
	 */
	public Bird fetch(String id) throws Exception {
		Query query = new Query();

		Criteria crt = new Criteria();
		crt.where("id").equals(id);

		query.addCriteria(crt);
		return mongoTemplate.findOne(query, Bird.class, MongoCollections.BIRDS.getStrcode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saltside.persistence.dao.birds.IBirdsDAO#add(com.common.pojo.Bird)
	 */
	public void add(Bird bird) throws Exception {
		mongoTemplate.insert(bird,MongoCollections.BIRDS.getStrcode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.saltside.persistence.dao.birds.IBirdsDAO#delete(java.lang.String)
	 */
	public void delete(String id) throws Exception {
		Query query = new Query();

		Criteria crt = new Criteria();
		crt.where("id").equals(id);

		query.addCriteria(crt);
		Bird dbird = fetch(id);
		mongoTemplate.findAndRemove(query, Bird.class,MongoCollections.BIRDS.getStrcode());
	}

}
