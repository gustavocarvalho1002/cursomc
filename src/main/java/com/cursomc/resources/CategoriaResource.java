package com.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cursomc.domain.Categoria;
import com.cursomc.services.CategoriaService;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	
	//Método de busca por ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//Categoria obj = service.buscar(id);
		//return ResponseEntity.ok().body(obj);
		
		try {
			Categoria obj = service.buscar(id);
			return ResponseEntity.ok().body(obj);
	    } catch (ObjectNotFoundException ex) {
	        throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, "Registro inexistente", ex);
	    }
	}
}
