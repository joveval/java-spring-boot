/**
 * 
 */
package app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import app.dao.TestDao;

/**
 * @author José Valenzuela Soto.
 *
 */
@Service
public class TestService {

	private static final Logger log = LoggerFactory.getLogger(TestService.class);

	@Autowired
	@Qualifier("testDaoImp01")
	TestDao testDao01;

	public boolean randomBoolean() throws InterruptedException {

		log.debug("Initiating Long process ...");
		Thread.sleep(3000);
		log.debug("Returning from Long process ...");
		double value = Math.random();
		Boolean response = (value >= 0.5);
		log.debug("Value of response randomBoolean():" + response);
		return response;
	}

	public boolean callingProcedure01() {
		int resp =0;
		try{
			resp = testDao01.executeProcedure01();
		}catch(MyException e){
			log.debug("[Controlled Exception]:"+e.getMessage());
		}
		
		return resp == 0;
	}

	public static class MyException extends RuntimeException {

		public MyException() {
			super();
		}

		public MyException(String message) {
			super(message);
		}

		public MyException(String message, Throwable cause) {
			super(message, cause);
		}

		public MyException(Throwable cause) {
			super(cause);
		}
	}

}
