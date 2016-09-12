/**
 * 
 */
package com.saltside.api.test.birds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.pojo.web.BirdRequest;
import com.saltside.foundation.exceptions.RecordNotFound;
import com.saltside.webapp.api.BirdControllerAPI;

/**
 * @author Goutham P N
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BirdsAPITest {
	private static final Logger _logger = Logger.getLogger(BirdsAPITest.class);

	@Autowired
	private BirdControllerAPI birdController;
	private static BirdRequest bird1, bird2;

	@BeforeClass
	public static void setUp() {
		
		bird1 = new BirdRequest();
		bird1.setId("id1");
		bird1.setName("bird1");
		bird1.setFamily("family1");
		bird1.setVisible(true);
		List<String> str1 = new ArrayList<String>();
		str1.add("continent1");
		bird1.setContinent(str1);

		bird2 = new BirdRequest();
		bird2.setId("id2");
		bird2.setName("bird2");
		bird2.setFamily("family2");
		List<String> str2 = new ArrayList<String>();
		str1.add("continent2");
		bird2.setContinent(str2);
	}

	@Test
	public void test1_findBird1Test1() {
		try {
			assertEquals(Status.NOT_FOUND.getStatusCode(), birdController.getBird("id1").getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test()
	public void test2_addBird1() {
		try {
			assertEquals(Status.OK.getStatusCode(),birdController.addBird(bird1).getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test3_findBird1Test2() {
		try {
			assertEquals(Status.OK.getStatusCode(), birdController.getBird("id1").getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test()
	public void test4_addBird2() {
		try {
			assertEquals(Status.OK.getStatusCode(),birdController.addBird(bird2).getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test5_findBird2Test1() {
		try {
			assertEquals(Status.OK.getStatusCode(), birdController.getBird("id2").getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test6_deleteBird1Test1() {
		try {
			assertEquals(Status.OK.getStatusCode(), birdController.deleteBird("id1").getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test7_deleteBird1Test1() {
		try {
			assertEquals(Status.NOT_FOUND.getStatusCode(), birdController.deleteBird("id1").getStatus());
		} catch (RecordNotFound ex) {
			return;
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test8_deleteBird2Test1() {
		try {
			assertEquals(Status.OK.getStatusCode(), birdController.deleteBird("id2").getStatus());
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}
}
