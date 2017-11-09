package app.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.model.Alumno;

@RepositoryRestResource
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Integer> {

	Page<Alumno> findAll(Pageable p);
}
