package app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/test1/{param1}")
	public ResponseEntity<?> testMethod(@PathVariable("param1") String param1,@RequestParam("li") Integer limit){
		
		return ResponseEntity.ok(new Message(param1));
	}
	 
	
	@PostMapping(value="/test2")
	public ResponseEntity<?> testPostMethod(@RequestBody Map<String, Object> objParams){
		
		if(!objParams.containsKey("paramGlobal")) return ResponseEntity.badRequest().build();
		boolean response = testService.callingProcedure01();
		Map<String, Object> map = new HashMap<>();
		map.put("result", response);
		return ResponseEntity.ok(map);
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
