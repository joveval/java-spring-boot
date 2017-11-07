package app.model;

import java.util.List;

public class Horario {

	private int idHorario;
	private String horaIni;
	private String horaFin;
	private List<Alumno> alumnos;
	
	public Horario() {
	}

	public Horario(int idHorario, String horaIni, String horaFin) {
		this.idHorario = idHorario;
		this.horaIni = horaIni;
		this.horaFin = horaFin;
	}

	public int getIdHorario() {
		return idHorario;
	}


	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}


	public String getHoraIni() {
		return horaIni;
	}


	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}


	public String getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	

	
	
	 
}
