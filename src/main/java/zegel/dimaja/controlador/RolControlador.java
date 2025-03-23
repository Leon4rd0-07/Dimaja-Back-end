package zegel.dimaja.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zegel.dimaja.modelo.Rol;
import zegel.dimaja.servicio.RolServicio;

import java.util.List;

//1. Indicar que es un controlador REST
@RestController
//2. Desplegar -- Mostrar en la web los datos
// http:localhost:8080/dimaja-app
@RequestMapping("dimaja-app") //Acceder al proyecto
//3. La url para la petición desde angular
@CrossOrigin(value = "http://localhost:4200")

public class RolControlador {
    //1. para mostrar mensajes en la consola
    private  static final Logger logger = LoggerFactory.getLogger(RolControlador.class);
    //2. Inyectar dependencia
    @Autowired
    private RolServicio rolServicio;
    // http:localhost:8080/dimaja-app/rol
    //Establecer una Url para el listado de rol
    @GetMapping("/rol")
    public List<Rol> obtenerrol(){
        //a. Traer la lista de usuarios
        List<Rol> rol = this.rolServicio.listarRol();
        //Mostrar en pantalla
        logger.info("Listado de Usuarios");
        rol.forEach((rols -> logger.info(rol.toString())));
        return rol;
    }
    // Endpoint para guardar un nuevo rol
    @PostMapping("/rol")
    public Rol guardarRol(@RequestBody Rol rol) {
        logger.info("Rol recibido: " + rol);
        Rol rolGuardado = rolServicio.guardarRol(rol);
        logger.info("Rol guardado: " + rolGuardado);
        return rolGuardado;
    }
}
