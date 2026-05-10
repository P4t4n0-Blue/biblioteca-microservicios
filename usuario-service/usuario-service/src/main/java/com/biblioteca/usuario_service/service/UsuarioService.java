package com.biblioteca.usuario_service.service;

import com.biblioteca.usuario_service.model.Usuario;
import com.biblioteca.usuario_service.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR
    public List<Usuario> listarUsuarios(){
        log.info("Listando usuarios");

        return usuarioRepository.findAll();
    }

    // GUARDAR
    public Usuario guardarUsuario(Usuario usuario){
        log.info("Guardando usuario");

        return usuarioRepository.save(usuario);
    }

    // BUSCAR
    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // ELIMINAR
    public void eliminarUsuario(Long id){
        log.info("Eliminando usuario");
        usuarioRepository.deleteById(id);
    }
}