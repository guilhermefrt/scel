package com.fatec.scel.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.scel.model.Aluno;
import com.fatec.scel.model.AlunoRepository;
import com.fatec.scel.model.Emprestimo;
import com.fatec.scel.model.EmprestimoRepository;
import com.fatec.scel.model.LivroRepository;
import com.fatec.scel.model.Servicos;

@RestController
@RequestMapping(path = "/emprestimos")
public class EmprestimoController {
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AlunoRepository usuarioRepository;
	@Autowired
	private Servicos servico;

	/**
	 * quando o usuario digita localhost:8080/emprestimos/cadastrar
	 *
	 * @param emprestimo
	 * @return o html /RegistrarEmprestimo
	 */
	@GetMapping("/cadastrar")
	public ModelAndView registrarEmprestimo(Emprestimo emprestimo) {
		ModelAndView mv = new ModelAndView("RegistrarEmprestimo");
		mv.addObject("emprestimo", emprestimo);
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Emprestimo emprestimo, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		
		emprestimo.setDataEmprestimo();
		emprestimoRepository.save(emprestimo);
		
		modelAndView.addObject("emprestimos", emprestimoRepository.findAll());
		return modelAndView;

	}

	@GetMapping("/consulta")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		modelAndView.addObject("emprestimos", emprestimoRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		emprestimoRepository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		modelAndView.addObject("emprestimos", emprestimoRepository.findAll());
		return modelAndView;
	}
}
