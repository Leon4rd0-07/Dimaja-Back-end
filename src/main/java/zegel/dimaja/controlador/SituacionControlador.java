package zegel.dimaja.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zegel.dimaja.modelo.Situacion;
import zegel.dimaja.servicio.SituacionServicio;

import java.util.List;

//1. Indicar que es un controlador REST
@RestController
//2. Desplegar -- Mostrar en la web los datos
// http:localhost:8080/dimaja-app
@RequestMapping("dimaja-app") //Acceder al proyecto
//3. La url para la petición desde angular
@CrossOrigin(value = "http://localhost:4200")

public class SituacionControlador {
    private static final Logger logger = LoggerFactory.getLogger(SituacionControlador.class);

    @Autowired
    private SituacionServicio situacionServicio;

    // Endpoint para obtener todas las situaciones
    @GetMapping("/situacion")
    public List<Situacion> obtenerSituaciones() {
        List<Situacion> situacion = situacionServicio.listarSituacion();
        logger.info("Listado de Situaciones:");
        situacion.forEach(situacions -> logger.info(situacion.toString()));
        return situacion;
    }

    // Endpoint para guardar una nueva situación
    @PostMapping("/situacion")
    public Situacion guardarSituacion(@RequestBody Situacion situacion) {
        logger.info("Situación recibida: " + situacion);
        Situacion situacionGuardada = situacionServicio.guardarSituacion(situacion);
        logger.info("Situación guardada: " + situacionGuardada);
        return situacionGuardada;
    }
}
