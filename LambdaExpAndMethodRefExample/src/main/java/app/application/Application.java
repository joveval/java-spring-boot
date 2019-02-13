/**
 * 
 */
package app.application;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author José Valenzuela Soto.
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@RestController
	@RequestMapping("/test")
	public static class TestController {
		
		@Autowired
		Test2OperationService operationService;
		
		@GetMapping("/lambda-exp-example")
		public ResponseEntity<?> lambda2OperationCalling(@RequestParam("p1") Integer a, @RequestParam("p2") Integer b,
				@RequestParam("op") String operation) {
			return operationService.operate(a,b,operation);
		}
	}

	
	@Service
	public static class Test2OperationService{

		/**
		 * @param a
		 * @param b
		 * @param operation
		 * @return
		 */
		public ResponseEntity<?> operate(Integer a, Integer b, String operation) {
			// TODO Auto-generated method stub
			Operator op;
			switch (operation) {
			case "sum":
				op = (m,n)->{return m+n;};
				break;
			case "product":
				op = (m,n)->{return m*n;};
				break;
			case "diff":
				op = (m,n)->{return m-n;};
				break;
			case "mod":
				op = (m,n)->{return m%n;};
				break;
			case "div":
				op = (m,n)->{return m/n;};
				break;
			default:
				return ResponseEntity.badRequest().body("Operation not supported");
				//break;
			}
			Integer result = op.operate(a, b);
			Map<String, Object> body = new HashMap<>();
			body.put("result",result);
			return ResponseEntity.ok(body);
		}
		
		
	}
	
	
	
	@FunctionalInterface
	public static interface Operator{
		public Integer operate(Integer a,Integer b);
	}
	
	
	
}
