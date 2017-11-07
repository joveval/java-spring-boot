package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.TestDao;
import app.model.Aula;

@Service
public class TestService {

	@Autowired
	TestDao testDao;
	
	public Aula getAulaHorarioAlumnos(int idAula){
		return testDao.getAulasById(idAula);
	}
	
}
