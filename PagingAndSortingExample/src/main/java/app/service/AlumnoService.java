package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.model.Alumno;
import app.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepo;
	
	public Page<Alumno> findAll(Pageable p){
		return alumnoRepo.findAll(p);
	}
}
