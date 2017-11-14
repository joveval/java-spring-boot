package app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

	@GetMapping("/test1/{param1}")
	public ResponseEntity<?> testMethod(@PathVariable("param1") String param1,@RequestParam("li") Integer limit){
		
		return ResponseEntity.ok(new Message(param1));
	}
	 
	
	public static class Message{
		private String gretting;

		
		
		public Message() {
		}

		public Message(String hello) {
			this.gretting = "hello "+hello;
		}

		public String getGretting() {
			return gretting;
		}

		public void setGretting(String gretting) {
			this.gretting = gretting;
		}

		
		
	}
}
