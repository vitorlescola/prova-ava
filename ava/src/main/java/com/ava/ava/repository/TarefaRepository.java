package com.ava.ava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ava.ava.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer>{
	
}