package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/validarAcceso")
    public Map<String, Object> validarAcceso(@RequestBody Map<String, Object> entrada) {

        int edad = Integer.parseInt(entrada.get("edad").toString());
        boolean pago = Boolean.parseBoolean(entrada.get("pago").toString());

        return eventoService.validarAcceso(edad, pago);
    }

    @PostMapping("/convertir")
    public Map<String, Object> convertirMoneda(@RequestBody Map<String, Object> entrada) {

        double dolares = Double.parseDouble(entrada.get("dolares").toString());
        double tipoCambio = Double.parseDouble(entrada.get("tipo_cambio").toString());

        return eventoService.conversionBs(dolares, tipoCambio);
    }
}
