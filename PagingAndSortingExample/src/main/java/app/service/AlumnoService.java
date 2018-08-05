package app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.dao.AlumnoDao;
import app.model.Alumno;
import app.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepo;
	
	@Autowired
	AlumnoDao alumnoDao;
	
	public Page<Alumno> findAll(Pageable p){
		return alumnoRepo.findAll(p);
	}
	
	public ResponseEntity<?> findAllFilters(Map<String, Object> filters){
		
		if(!validate(filters)){
			return ResponseEntity.badRequest().build();
		}
		
		
		
		List<Alumno> alumnos = alumnoDao.findAll(filters);
		if(alumnos!=null){
			
			Resources<Alumno> pagedRes = new Resources<>(alumnos);
			return ResponseEntity.ok(pagedRes);
		}else{
			return ResponseEntity.notFound().build();
		}
		
		
	}

	/**
	 * @param filters
	 * @return
	 */
	private boolean validate(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		
		String nameLike = (String) filters.get("nameLike");
		String apellidos = (String)	filters.get("apellidosLike");
		String promLow = (String) filters.get("promLow");
		String promHigh = (String) filters.get("primHigh");
		
		if(nameLike!=null){
			
		}
		if(apellidos!=null){
					
				}
		if(promLow!=null){
			
			if(!promLow.matches("^(\\d*\\.)?\\d+$")) return false;
		}
		if(promHigh!=null){
			if(!promHigh.matches("^(\\d*\\.)?\\d+$"))return false;
		}
		
		
		return true;
	}
}
