package app.model;

import java.util.List;


public class Aula {

	private int idAula;
	private String codAula;
	private int nivel;
	private List<Horario> horarios;

	public Aula() {
	}
	public Aula(int idAula, String codAula, int nivel) {
		this.idAula = idAula;
		this.codAula = codAula;
		this.nivel = nivel;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public String getCodAula() {
		return codAula;
	}
	public void setCodAula(String codAula) {
		this.codAula = codAula;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	
}
