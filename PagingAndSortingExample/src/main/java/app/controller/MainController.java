package app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Alumno;
import app.service.AlumnoService;

@RestController
public class MainController {

	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping(value=RoutingConstants.WS_ALUMNOS_EP,produces="application/json")
	public ResponseEntity<?> getAlumnos(@PageableDefault Pageable p,PagedResourcesAssembler<Alumno> assembler){
		
		Page<Alumno> alumnos = alumnoService.findAll(p);
		if(alumnos!=null){
			PagedResources<Resource<Alumno>> pagedRes = assembler.toResource(alumnos);
			return ResponseEntity.ok(pagedRes);
		}else{
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping(value=RoutingConstants.WS_ALUMNOS_FL,produces="application/json")
	public ResponseEntity<?> getAlumnosFilter(@RequestParam Map<String,Object> params){	
		return alumnoService.findAllFilters(params);
	
	}
	
	
}
