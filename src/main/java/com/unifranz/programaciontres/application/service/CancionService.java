package com.unifranz.programaciontres.application.service;

import com.unifranz.programaciontres.application.dto.CancionDto;

import java.util.List;

public interface CancionService {
    CancionDto guardar(CancionDto cancionDto);
    List<CancionDto> listar();
    List<CancionDto> listarPorGenero(String genero);
}
