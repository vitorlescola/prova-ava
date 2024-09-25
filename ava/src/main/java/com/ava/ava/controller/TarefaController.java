package com.ava.ava.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ava.ava.model.Tarefa;
import com.ava.ava.repository.TarefaRepository;

@Controller
public class TarefaController {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping("/criarTarefa")
	public String criarTarefa(Model modelo) {
		modelo.addAttribute("tarefa",new Tarefa());
		return "criarTarefa";
	}
	
	@PostMapping("/salvarTarefa")
	public String salvarTarefa(@ModelAttribute Tarefa tarefa, @RequestParam String status) {
	    tarefa.setStatus(Tarefa.StatusTarefa.valueOf(status));
	    tarefaRepository.save(tarefa);
	    return "redirect:/lista";
	}
	
	@GetMapping("removerTarefa/{id}")
	public String removerTarefa(@PathVariable int id) {
		tarefaRepository.deleteById(id);
		return "redirect:/criarTarefa";
	}
	
	@GetMapping("editarTarefa/{id}")
	public String editarTarefa(@PathVariable int id, Model modelo) {
		Optional<Tarefa> tarefaOpt=tarefaRepository.findById(id);
		if(tarefaOpt.isPresent()) {
			modelo.addAttribute("tarefa",tarefaOpt.get());
			return "criarTarefa";
		}else {
			return "redirect:/criarTarefa";	
		}
	}
	@GetMapping("/lista")
	public String listarTarefa(Model modelo) {
		modelo.addAttribute("tarefa", tarefaRepository.findAll());
		
		return "lista";
	}
}