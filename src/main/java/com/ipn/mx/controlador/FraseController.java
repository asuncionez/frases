package com.ipn.mx.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.modelo.entidades.Frase;
import com.ipn.mx.modelo.servicios.IFraseService;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiFrases")
public class FraseController {
	@Autowired
	private IFraseService service;
	
	
	@GetMapping("/frases")
	public List<Frase> readAll(){
		return service.findAll();
	}
	
	
	@GetMapping("/frases/random")
	public Frase readRandom(){
		return service.aleatorizar(service.findAll());
	}
	
	
	
	@PostMapping("/frases")
	@ResponseStatus(HttpStatus.CREATED)
	public Frase save(@RequestBody Frase frase) {
		return service.save(frase);
	}
	
	@GetMapping("/frases/{id}")
	public Frase read(@PathVariable Long id) {
		return service.findById(id);
	}
	
	
	@DeleteMapping("/frases/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PutMapping("/frases/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Frase update(@RequestBody Frase frase, 
			@PathVariable Long id) {
		Frase c = service.findById(id);
		c.setTexto(frase.getTexto());
		c.setAutor(frase.getAutor());
		
		
		return service.save(frase);
	}
		
	

}
