package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Aula;
import app.service.TestService;

@RestController
@RequestMapping("/test/aulas")
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/default")
	public ResponseEntity<?> getAulaPorId(@RequestParam("idaula")int idAula){
		
		return ResponseEntity.ok(testService.getAulaHorarioAlumnos(idAula));
		
	}
	
	@GetMapping("/custom")
	public ResponseEntity<?> getAulaPorIdv2(@RequestParam("idaula")int idAula){
		
		//List<Link> links = new ArrayList<>();
		Resource<Aula> res = new Resource<Aula>(testService.getAulaHorarioAlumnos(idAula));
		return ResponseEntity.ok(res);
		
	}
	
}
