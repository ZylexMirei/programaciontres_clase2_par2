package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.dto.CancionDto;
import com.unifranz.programaciontres.application.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @PostMapping
    public ResponseEntity<CancionDto> guardar(@RequestBody CancionDto cancionDto) {
        CancionDto cancion = cancionService.guardar(cancionDto);
        return ResponseEntity.ok(cancion);
    }

    @GetMapping
    public ResponseEntity<List<CancionDto>> listarCanciones() {
        return ResponseEntity.ok(cancionService.listar());
    }

    @GetMapping("/genero")
    public ResponseEntity<List<CancionDto>> listarPorGenero(@RequestParam String genero) {
        return ResponseEntity.ok(cancionService.listarPorGenero(genero));
    }
}
