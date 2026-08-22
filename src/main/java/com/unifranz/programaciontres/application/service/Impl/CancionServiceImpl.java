package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.dto.CancionDto;
import com.unifranz.programaciontres.application.service.CancionService;
import com.unifranz.programaciontres.domain.Cancion;
import com.unifranz.programaciontres.infrastructure.persistence.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CancionServiceImpl implements CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    @Override
    public CancionDto guardar(CancionDto cancionDto) {
        Cancion cancion = new Cancion();
        cancion.setTitulo(cancionDto.getTitulo());
        cancion.setArtista(cancionDto.getArtista());
        cancion.setGenero(cancionDto.getGenero());
        cancion.setDuracionSegundos(cancionDto.getDuracionSegundos());

        Cancion guardada = cancionRepository.save(cancion);
        return convertirDto(guardada);
    }

    @Override
    public List<CancionDto> listar() {
        return cancionRepository.findAll()
                .stream()
                .map(this::convertirDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CancionDto> listarPorGenero(String genero) {
        return cancionRepository.findByGeneroIgnoreCase(genero)
                .stream()
                .map(this::convertirDto)
                .collect(Collectors.toList());
    }

    private CancionDto convertirDto(Cancion cancion) {
        return new CancionDto(
                cancion.getId(),
                cancion.getTitulo(),
                cancion.getArtista(),
                cancion.getGenero(),
                cancion.getDuracionSegundos()
        );
    }
}
