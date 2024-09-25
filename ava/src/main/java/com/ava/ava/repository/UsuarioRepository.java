package com.ava.ava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ava.ava.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}