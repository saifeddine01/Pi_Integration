package tn.esprit.spring;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class TimesheetApplicationTests {
	private static final Logger logger = Logger.getLogger(DepartementTest.class);
	@Test
	public void contextLoads() {
		logger.info("Hello ");
	}

}
