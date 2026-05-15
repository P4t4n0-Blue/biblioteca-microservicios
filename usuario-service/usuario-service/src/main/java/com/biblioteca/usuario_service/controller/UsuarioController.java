package com.biblioteca.usuario_service.controller;

import com.biblioteca.usuario_service.model.Usuario;
import com.biblioteca.usuario_service.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario usuario) {
        log.info("Intentando registrar usuario con correo: {}", usuario.getCorreo());

        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);

        log.info("Usuario guardado con éxito. ID: {}", nuevoUsuario.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);

        usuario.setNombre(usuarioActualizado.getNombre());

        usuario.setCorreo(usuarioActualizado.getCorreo());

        usuario.setTelefono(usuarioActualizado.getTelefono());
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado");
    }
}