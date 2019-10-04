package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {
	
	private PessoaService pessoaService;

	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.create(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		return pessoa.map(p -> new ResponseEntity<Pessoa>(p, HttpStatus.OK)).orElse(new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND));
	}

	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping
	public ResponseEntity<List<Pessoa>> list() {
		List<Pessoa> pessoas = pessoaService.list();
		return ResponseEntity.ok(pessoas);
	}
	
	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		pessoaService.remove(id);
	}
	
	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaConsultada = pessoaService.findById(id);
		
		BeanUtils.copyProperties(pessoa, pessoaConsultada.get(), "id");
		
		Pessoa pessoaSalva = pessoaService.update(pessoa);
		return ResponseEntity.ok().body(pessoaSalva);
	}


}
