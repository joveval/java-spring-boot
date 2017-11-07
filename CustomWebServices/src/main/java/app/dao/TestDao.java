package app.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import app.model.Alumno;
import app.model.Aula;
import app.model.Horario;

@Component
public class TestDao {

	private List<Aula> aulas;
	
	
	
	public TestDao() {
		
		
		aulas = new ArrayList<>();
		
		
		Aula aulaNueva = new Aula();
		
		aulaNueva.setIdAula(1);
		aulaNueva.setNivel(1);
		
		Horario horario1 = new Horario(1, "08:00", "10:00");
		
		Alumno alumno1 = new Alumno(1, "José Manuel Valenzuela Soto", 15.0);
		Alumno alumno2 = new Alumno(2, "Jhon Mejía", 12.0);
		Alumno alumno3 = new Alumno(3, "Maryan Quiñones", 19.0);
		Alumno alumno4 = new Alumno(4, "Kath Rodriguez", 15.0);
		Alumno alumno5 = new Alumno(5, "Kevin Sandón", 17.0);
		Alumno alumno6 = new Alumno(6, "Jorge Rodriguez", 15.0);
		Alumno alumno7 = new Alumno(7, "Maria Parado de Bellido", 16.0);
		
		List<Alumno> alumnosHorario1 = Arrays.asList(alumno1,alumno2,alumno3);
		horario1.setAlumnos(alumnosHorario1);
		
		Horario horario2 = new Horario(1, "08:30", "10:30");
		List<Alumno> alumnosHorario2 = Arrays.asList(alumno4,alumno5,alumno6,alumno7);
		horario2.setAlumnos(alumnosHorario2);
		
		aulaNueva.setHorarios(Arrays.asList(horario1,horario2));
		
		aulas.add(aulaNueva);
		
		aulaNueva = new Aula();
		
		aulaNueva.setIdAula(2);
		aulaNueva.setNivel(1);
	
		aulaNueva.setHorarios(Arrays.asList(horario1));
		aulas.add(aulaNueva);
		
	}



	public Aula getAulasById(Integer idAula){
		
		Aula resultado = null;
		
		for (Aula aula:aulas) {
			if(aula.getIdAula()==idAula){
				return aula;
			}
		}
		
		return resultado;
		
	}
}
