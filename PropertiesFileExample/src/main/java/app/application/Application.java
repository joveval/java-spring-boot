/**
 * 
 */
package app.application;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
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
	public static class DummyClass{
		
		@Autowired
		RunTimeConf runtimeConf;
		
		@Value("${app.name}")
		private String myAppName;

		@GetMapping("/test/properties")
		public ResponseEntity<?> readPropertiesFileValues(){
			String appName = "My app name is "+myAppName;
			return ResponseEntity.ok(appName);
		}
		
		@GetMapping("/test/properties2")
		public ResponseEntity<?> readPropertiesFromConfClazz(){
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("app-runtime-prod", runtimeConf.getProd());
			map.put("app-runtime-create-database", runtimeConf.getCreateDatabase());
			return ResponseEntity.ok(map);
		}
		
		
		
	}
	
	
	@Component
	@ConfigurationProperties(prefix="app.runtime")
	public static class RunTimeConf{
		private Boolean prod;
		private Boolean createDatabase;
		public Boolean getProd() {
			return prod;
		}
		public void setProd(Boolean prod) {
			this.prod = prod;
		}
		public Boolean getCreateDatabase() {
			return createDatabase;
		}
		public void setCreateDatabase(Boolean createDatabase) {
			this.createDatabase = createDatabase;
		}
		
		
	}
	
	
	

}
