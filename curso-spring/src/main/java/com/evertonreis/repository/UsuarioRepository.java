package com.evertonreis.repository;

import com.evertonreis.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT * FROM usuario WHERE email = ?1 AND senha = ?2")
    public Optional<Usuario> login(String email, String senha);
}
