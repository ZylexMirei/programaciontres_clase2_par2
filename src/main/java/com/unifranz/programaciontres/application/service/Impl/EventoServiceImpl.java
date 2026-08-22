package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.service.EventoService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EventoServiceImpl implements EventoService {

    @Override
    public Map<String, Object> validarAcceso(int edad, boolean pago) {
        Map<String, Object> respuesta = new HashMap<>();

        if (edad >= 18 && pago) {
            respuesta.put("acceso", true);
            respuesta.put("mensaje", "Acceso permitido al evento.");
        } else if (edad < 18) {
            respuesta.put("acceso", false);
            respuesta.put("mensaje", "Acceso denegado: debe ser mayor de edad.");
        } else {
            respuesta.put("acceso", false);
            respuesta.put("mensaje", "Acceso denegado: falta realizar el pago.");
        }

        return respuesta;
    }

    @Override
    public Map<String, Object> conversionBs(double dolares, double tipoCambio) {
        Map<String, Object> respuesta = new HashMap<>();

        double bolivianos = dolares * tipoCambio;

        respuesta.put("dolares_recibidos", dolares);
        respuesta.put("tipo_cambio", tipoCambio);
        respuesta.put("total_bolivianos", bolivianos);

        return respuesta;
    }
}
