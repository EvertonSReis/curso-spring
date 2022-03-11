package com.evertonreis.services;

import com.evertonreis.domain.Usuario;
import com.evertonreis.repository.UsuarioRepository;
import com.evertonreis.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario save(Usuario usuario){
        Usuario createdUsuario = repository.save(usuario);
        return createdUsuario;
    }

    public Usuario update(Usuario usuario){
        Usuario updateUsuario = repository.save(usuario);
        return updateUsuario;
    }

    public Usuario getById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.get();
    }

    public List<Usuario> listAll(){
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    public Usuario login(String email, String senha){
        senha = HashUtil.getSecureHash(senha);

        Optional<Usuario> obj = repository.login(email, senha);
        return obj.get();
    }
}
