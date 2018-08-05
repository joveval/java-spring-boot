/**
 * 
 */
package app.dao;

import java.util.List;
import java.util.Map;

import app.model.Alumno;

/**
 * @author José Valenzuela Soto.
 *
 */
public interface AlumnoDao {

	public List<Alumno> findAll(Map<String, Object> filters);
	
}
