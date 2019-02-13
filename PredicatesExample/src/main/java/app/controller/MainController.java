/**
 * 
 */
package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.PredicateService;

/**
 * @author José Valenzuela Soto.
 *
 */
@RestController
public class MainController {

	@Autowired
	PredicateService predicateService;
	
	@GetMapping("/personas/findBy")
	public ResponseEntity<?> findByFilters(@RequestParam("p1") String nombre,@RequestParam("p2") String apellidos,@RequestParam("id") Integer id){
		
		return predicateService.getPersonasByFilter(nombre,apellidos,id);
	}
}
