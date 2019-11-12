package com.fatec.scel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.scel.model.Aluno;

@RestController
@RequestMapping(path = "/")
public class HomeController {
	@GetMapping("/")
	public ModelAndView cadastraLivro(Aluno aluno) {
		ModelAndView mv = new ModelAndView("cadastrarAluno");
		mv.addObject("aluno", aluno);
		return mv;
	}
}
