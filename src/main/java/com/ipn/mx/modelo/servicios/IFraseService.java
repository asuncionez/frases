package com.ipn.mx.modelo.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Frase;



public interface IFraseService {
	public List<Frase> findAll();
	public Frase findById(Long id);
	public Frase save(Frase frase);
	public void delete(Long id);
	
	//Metodo para aleatorizar la frase
	public Frase aleatorizar(List<Frase> listaDeFrases); 
}
