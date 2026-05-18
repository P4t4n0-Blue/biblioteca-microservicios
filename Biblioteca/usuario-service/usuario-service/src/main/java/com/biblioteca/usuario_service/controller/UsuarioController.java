package com.biblioteca.usuario_service.controller;

import com.biblioteca.usuario_service.dto.UsuarioDTO;
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
        log.info("Controller: Solicitando lista de todos los usuarios");
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id){
        log.info("Controller: Buscando usuario con ID: {}", id);
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        log.info("Controller: Creando usuario con correo: {}", usuarioDTO.getCorreo());
        Usuario nuevo = usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        log.info("Controller: Petición para actualizar ID: {}", id);
        Usuario actualizado = usuarioService.actualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        log.warn("Controller: Eliminando usuario con ID: {}", id);
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado");
    }
}