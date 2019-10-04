package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
