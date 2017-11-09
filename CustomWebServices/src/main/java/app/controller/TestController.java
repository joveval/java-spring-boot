package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> getAulaPorId(@RequestParam("idaula")int idAula,@RequestParam("tipres")Integer tipoRespuesta){
		
		ErrorMessage error = null;
		switch(tipoRespuesta){
		case 1:
			return ResponseEntity.ok(testService.getAulaHorarioAlumnos(idAula));
		case 2:
			
			error = new ErrorMessage(400, "Bad Request");
			return ResponseEntity.badRequest().body(error);
		default:
			error = new ErrorMessage(404, "Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
		
		//return ResponseEntity.ok(testService.getAulaHorarioAlumnos(idAula));
		
	}
	
	@GetMapping("/custom")
	public ResponseEntity<?> getAulaPorIdv2(@RequestParam("idaula")int idAula){
		
		//List<Link> links = new ArrayList<>();
		Resource<Aula> res = new Resource<Aula>(testService.getAulaHorarioAlumnos(idAula));
		return ResponseEntity.ok(res);
		
	}
	
	public static class ErrorMessage{
		private int status;
		private String message;
		
		
		public ErrorMessage() {
		}


		public ErrorMessage(int status, String message) {
			this.status = status;
			this.message = message;
		}


		public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
		
	}
	
}
