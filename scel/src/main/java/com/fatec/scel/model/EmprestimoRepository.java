package com.fatec.scel.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
	
}