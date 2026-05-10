package com.biblioteca.multa_service.controller;

import com.biblioteca.multa_service.model.Multa;
import com.biblioteca.multa_service.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/multas")
public class MultaController {

    @Autowired
    private MultaService multaService;

    // GET
    @GetMapping
    public ResponseEntity<List<Multa>> listarMultas(){
        return ResponseEntity.ok(multaService.listarMultas());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Multa> buscarMulta(@PathVariable Long id){
        return ResponseEntity.ok(multaService.buscarMulta(id));
    }

    // POST
    @PostMapping
    public ResponseEntity<Multa> guardarMulta(@RequestBody Multa multa){
        return ResponseEntity.ok(multaService.guardarMulta(multa));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMulta(@PathVariable Long id){

        multaService.eliminarMulta(id);
        return ResponseEntity.ok("Multa eliminada");
    }
}