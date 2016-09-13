/**
 * 
 */
package com.saltside.api.test.birds;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Goutham P N
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MongoTest {
	private static final Logger _logger = Logger.getLogger(MongoTest.class);

	@Autowired
	private MongoTemplate mongoTemplate;


	@Test
	public void test1_MongoTest() {
		if (null == mongoTemplate)
			fail("Mongo Connection Failed");
	}

}
