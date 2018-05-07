/**
 * 
 */
package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.model.DataTb02;

/**
 * @author José Valenzuela Soto.
 *
 */
@RepositoryRestResource
public interface DataTb02Repository extends JpaRepository<DataTb02, Integer> {

}
