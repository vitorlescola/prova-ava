package com.ava.ava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ava.ava.model.Usuario;
import com.ava.ava.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}