package com.unifranz.programaciontres.application.service.impl;

import com.unifranz.programaciontres.application.service.EventoService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EventoServiceImpl implements EventoService {

    // ... aquí mantienes tu otro método validarAcceso ...

    @Override
    public Map<String, Object> conversionBs(double dolares) {
        Map<String, Object> respuesta = new HashMap<>();

        // Tipo de cambio oficial referencial
        double tipoCambio = 6.96;
        double bolivianos = dolares * tipoCambio;

        respuesta.put("dolares_recibidos", dolares);
        respuesta.put("tasa_cambio", tipoCambio);
        respuesta.put("total_bolivianos", bolivianos);

        return respuesta;
    }
}