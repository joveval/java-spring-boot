/**
 * 
 */
package app.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.dao.TestDao;
import app.model.DataTb01;
import app.model.DataTb02;
import app.model.UvMyView;
import app.service.TestService;
import app.service.TestService.MyException;

/**
 * @author José Valenzuela Soto.
 *
 */
@Repository("testDaoImp01")
public class TestDaoImp implements TestDao {

	private static final Logger log = LoggerFactory.getLogger(TestDaoImp.class);

	@Autowired
	EntityManager em;

	@Autowired
	TestService testService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see app.dao.TestDao#executeProcedure01()
	 */
	@Override
	@Transactional(rollbackFor={MyException.class})
	public int executeProcedure01() {
		// TODO Auto-generated method stub
		log.debug("Initiating TX ...");
		
		DataTb01 d1 = new DataTb01();
		d1.setFieldOne("afjsdflasdlkf");
		d1.setFieldTwo("asdfjalñdfj");
		
		em.persist(d1);
		em.flush();
		
		//Integer newId = d1.getId();
		DataTb02 d2 = new DataTb02();
		d2.setFieldFour("someValue");
		d2.setFieldThree("Some Values");
		d2.setDataTb01(d1);
		
		em.persist(d2);
		em.flush();
		
		
		StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("my_stored_procedure").setParameter("Param1",
				1);
		log.debug("Executing procedure ...");
		sp.execute();

		try {
			
			List<?> resultSet = sp.getResultList();
			log.debug("cantidad:"+resultSet.size());
			List<UvMyView> listaResponse = new ArrayList<>();
			resultSet.forEach(v->{listaResponse.add((UvMyView)v);});
			listaResponse.forEach(v->{log.debug(v.getId().toString());});
			
			if (testService.randomBoolean()) {
				log.debug("Commiting changes ...");
			} else {
				
				log.debug("Rollbacking changes ...");
				throw new MyException("Bad response from external source");
			}
		} catch (InterruptedException e) {
			log.error("Error", e);
			log.debug("Rollbacking changes ...");
			throw new MyException("Bad response from external source");
		}

		return 0;
	}

}
