package com.ava.ava.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ava.ava.model.Usuario;
import com.ava.ava.repository.UsuarioRepository;
import com.ava.ava.service.UsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/criar")
    public String criarConta(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "criar";
    }
    
    @PostMapping("/salvarUsuario")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }
    
    @GetMapping("removerUsuario/{id}")
    public String removerUsuario(@PathVariable int id) {
        usuarioRepository.deleteById(id);
        return "redirect:/criar";
    }
    
    @GetMapping("editarUsuario/{id}")
    public String editarUsuario(@PathVariable int id, Model modelo) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            modelo.addAttribute("usuario", usuarioOpt.get());
            return "criar";
        } else {
            return "redirect:/criar";    
        }
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @PostMapping("/login/autentificacao")
    public String authenticate(@ModelAttribute Usuario usuario, Model modelo) {
        Usuario usuarioEncontrado = usuarioService.findByEmail(usuario.getEmail());
        
        if (usuarioEncontrado != null) {
            return "redirect:/criarTarefa";
        } else {
            modelo.addAttribute("error", "Credenciais inválidas");
            return "login";
        }
    }
}