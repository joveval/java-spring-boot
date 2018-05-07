/**
 * 
 */
package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.model.DataTb01;

/**
 * @author José Valenzuela Soto.
 *
 */
@RepositoryRestResource
public interface DataTb01Repository extends JpaRepository<DataTb01, Integer> {

}
