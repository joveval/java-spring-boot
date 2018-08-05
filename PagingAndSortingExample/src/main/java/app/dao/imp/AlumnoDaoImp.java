/**
 * 
 */
package app.dao.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.dao.AlumnoDao;
import app.model.Alumno;

/**
 * @author José Valenzuela Soto.
 *
 */
@Repository("alumnoDao")
public class AlumnoDaoImp implements AlumnoDao{

	@Autowired
	EntityManager em;
	
	/* (non-Javadoc)
	 * @see app.dao.AlumnoDao#findAll(java.util.function.Predicate)
	 */
	@Override
	public List<Alumno> findAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Alumno> query = builder.createQuery(Alumno.class);
		Root<Alumno> root = query.from(Alumno.class);
		
		String nameLike = (String) params.get("nameLike");
		String apellidos = (String)	params.get("apellidosLike");
		String promLow = (String) params.get("promLow");
		String promHigh = (String) params.get("primHigh");
		List<Predicate> predicates = new ArrayList<>();
		if(nameLike!=null){
			Predicate p = builder.like(root.<String>get("nombres"), "%"+nameLike+"%");
			predicates.add(p);
		}
		
		if(apellidos!=null){
			Predicate p = builder.like(root.<String>get("apellidos"), "%"+apellidos+"%");
			predicates.add(p);
		}
		
		
		if(promLow!=null){
			
			Predicate p = builder.greaterThanOrEqualTo(root.<BigDecimal>get("promedio"), new BigDecimal(promLow));
			predicates.add(p);
		}
		
		if(promHigh!=null){
			Predicate p = builder.lessThanOrEqualTo(root.<BigDecimal>get("promedio"), new BigDecimal(promHigh));
			predicates.add(p);
		}
		
		
		
		Predicate p;
		if(predicates.size()>0){
			 p= predicates.get(0);
			 for(Predicate pAux:predicates){
				 p = builder.and(p,pAux);
			 }
			 query.where(p);
		}
		
		
		
		
		return em.createQuery(query.select(root)).setMaxResults(10).setFirstResult(0).getResultList();

	}

}
