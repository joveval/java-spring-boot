package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.AlumnoService;

@RestController
public class MainController {

	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping("/alumnos/paged")
	public ResponseEntity<?> getAlumnos(@PageableDefault Pageable p,PagedResourcesAssembler<?> assembler){
		
		Page alumnos = alumnoService.findAll(p);
		
		PagedResources<Resource> pagedRes = assembler.toResource(alumnos);
		
		if(alumnos!=null){
			return ResponseEntity.ok(pagedRes);
		}else{
			return ResponseEntity.notFound().build();
		}
		
		//return ResponseEntity.ok(pagedRes);
	}
}
