/**
 * 
 */
package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.model.Alumno;

/**
 * @author José Valenzuela Soto.
 *
 */
@Repository("alumnoJPARepository")
public interface AlumnoJPARepository extends JpaRepository<Alumno, Integer> {

	
}
