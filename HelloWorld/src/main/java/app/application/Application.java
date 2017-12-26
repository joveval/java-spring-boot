/**
 * 
 */
package app.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
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
		log.info("Hello World!");
	}

	@RestController
	@RequestMapping("/hello")
	public static class TestController{
		

		@GetMapping("/byName")
		public ResponseEntity<?> helloByName(@RequestParam(value="n",required=false,defaultValue="invitado") String name){
			return ResponseEntity.ok("Hello "+name);
		}
	}
	
	
}
