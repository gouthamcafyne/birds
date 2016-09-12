/**
 * 
 */
package com.saltside.service.test.birds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.pojo.Bird;
import com.saltside.foundation.exceptions.RecordNotFound;
import com.saltside.service.bird.IBirdService;

/**
 * @author Goutham P N
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BirdsServiceTest {
	private static final Logger _logger = Logger.getLogger(BirdsServiceTest.class);

	@Autowired
	private IBirdService birdService;
	private Bird bird1, bird2;

	@Before
	public void setUp() {
		bird1 = new Bird();
		bird1.setId("id1");
		bird1.setName("bird1");
		bird1.setFamily("family1");
		bird1.setVisible(true);
		List<String> str1 = new ArrayList<String>();
		str1.add("continent1");
		bird1.setContinents(str1);

		bird2 = new Bird();
		bird2.setId("id2");
		bird2.setName("bird2");
		bird2.setFamily("family2");
		List<String> str2 = new ArrayList<String>();
		str1.add("continent2");
		bird2.setContinents(str2);
	}

	@Test
	public void test1_findBird1Test1() {
		try {
			assertEquals(null, birdService.getBird("id1"));
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test()
	public void test2_addBird1() {
		try {
			birdService.addBird(bird1);
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test3_findBird1Test2() {
		try {
			assertEquals(bird1, birdService.getBird("id1"));
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test()
	public void test4_addBird2() {
		try {
			birdService.addBird(bird2);
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test5_findBird2Test1() {
		try {
			assertEquals(bird2, birdService.getBird("id2"));
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test6_deleteBird1Test1() {
		try {
			assertEquals(bird1, birdService.deleteBird("id1"));
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}

	@Test
	public void test7_deleteBird1Test1() {
		try {
			birdService.deleteBird("id1");
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
			birdService.deleteBird("id2");
		} catch (Exception e) {
			_logger.error(e.getMessage());
			fail();
		}
	}
}
