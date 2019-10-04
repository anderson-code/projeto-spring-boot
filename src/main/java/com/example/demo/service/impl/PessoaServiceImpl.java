package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import com.example.demo.util.Teste;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private Teste teste;

	@Autowired
	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public Pessoa create(Pessoa pessoa) {
		logger.info("Criando pessoa -> {}", pessoa);
		pessoa.getEndereco().setPessoa(pessoa);
		teste.teste();
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Pessoa update(Pessoa pessoa) {
		logger.info("Alterando pessoa -> {}", pessoa);
		pessoa.getEndereco().setPessoa(pessoa);
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}
	
	@Override
	public List<Pessoa> list() {
		return pessoaRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		pessoaRepository.deleteById(id);
	}

}
