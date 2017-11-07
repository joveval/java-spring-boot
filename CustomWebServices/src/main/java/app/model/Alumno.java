package app.model;

public class Alumno {

	private int idAlumno;
	private String nombreAlumno;
	private double promedio;
		
	public Alumno() {
	}


	public Alumno(int idAlumno, String nombreAlumno, double promedio) {
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.promedio = promedio;
	}


	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	public String getNombreAlumno() {
		return nombreAlumno;
	}


	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}


	public double getPromedio() {
		return promedio;
	}


	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	
	
}
