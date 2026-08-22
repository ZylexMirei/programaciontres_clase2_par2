package com.unifranz.programaciontres.infrastructure.persistence;

import com.unifranz.programaciontres.domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    List<Cancion> findByGeneroIgnoreCase(String genero);
}
