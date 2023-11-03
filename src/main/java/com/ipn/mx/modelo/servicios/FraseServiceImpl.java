package com.ipn.mx.modelo.servicios;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.dao.FraseDAO;
import com.ipn.mx.modelo.entidades.Frase;
@Service
public class FraseServiceImpl implements IFraseService{
	@Autowired
	 FraseDAO dao;
	
	@Override
	@Transactional(readOnly = false) 
	public List<Frase> findAll() {
		return (List<Frase>)dao.findAll();
	}

	@Override
	@Transactional(readOnly = false) 
	public Frase findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Frase save(Frase frase) {
		return dao.save(frase);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Frase aleatorizar(List<Frase> listaDeFrases) {
		return listaDeFrases.get(new Random().nextInt(listaDeFrases.size()));
		
	}
	
	
}
