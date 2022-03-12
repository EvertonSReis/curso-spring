package com.evertonreis.resource;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Usuario;
import com.evertonreis.dto.UserLoginDto;
import com.evertonreis.services.RequestService;
import com.evertonreis.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario createdUsuario = service.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario){
        Usuario updateUsuario = service.save(usuario);
        return ResponseEntity.ok(updateUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listBy(@PathVariable("id") Long id){
        Usuario usuario = service.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(){
        List<Usuario> usuarios = service.listAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("//login")
    public ResponseEntity<Usuario> login(@RequestBody UserLoginDto usuario){
        Usuario loggedUsuario = service.login(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.ok(loggedUsuario);
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<List<Request>> listAllRequestById(@PathVariable(name = "id") Long id){
        List<Request> requests = requestService.listAllByUsuarioId(id);
        return ResponseEntity.ok(requests);
    }
}
