package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Pessoa;

public interface PessoaService {

	Pessoa create(Pessoa pessoa);

	Pessoa update(Pessoa pessoa);

	Optional<Pessoa> findById(Long id);
	
	List<Pessoa> list();

	void remove(Long id);


	
}
