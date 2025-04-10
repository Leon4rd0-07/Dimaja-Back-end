package zegel.dimaja.controlador;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zegel.dimaja.modelo.Productos;
import zegel.dimaja.modelo.Usuarios;
import zegel.dimaja.servicio.UsuariosServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1. Indicar que es un controlador REST
@RestController
//2. Desplegar -- Mostrar en la web los datos
// http:localhost:8080/dimaja-app
@RequestMapping("dimaja-app") //Acceder al proyecto
//3. La url para la petición desde angular
@CrossOrigin(value = "http://localhost:4200")

public class UsuariosControlador {
    //1. para mostrar mensajes en la consola
    private  static final Logger logger = LoggerFactory.getLogger(UsuariosControlador.class);
    //2. Inyectar dependencia
    @Autowired
    private UsuariosServicio usuariosServicio;

    // http:localhost:8080/dimaja-app/usuarios
    //Establecer una Url para el listado de usuarios
    @GetMapping("/usuarios")
    public List<Usuarios> obtenerUsuarios(){
        //a. Traer la lista de usuarios
        List<Usuarios> usuarios = this.usuariosServicio.listarUsuarios();
        //Mostrar en pantalla
        logger.info("Listado de Usuarios");
        usuarios.forEach((usuario -> logger.info(usuarios.toString())));
        return usuarios;
    }

    // Endpoint para guardar un nuevo usuario
    @PostMapping("/usuarios")
    public Usuarios guardarUsuario(@RequestBody Usuarios usuario) {
        logger.info("Usuario recibido: " + usuario);
        Usuarios usuarioGuardado    = usuariosServicio.guardarUsuarios(usuario);
        logger.info("Usuario guardado: " + usuario.toString());
        return usuarioGuardado;
    }

    @GetMapping("/usuarios/{id}")
    public Usuarios obtenerUsuarioPorId(@PathVariable Integer id) {
        logger.info("Buscando usuario con ID: " + id);
        return usuariosServicio.buscarUsuariosId(id);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuariosServicio.eliminarUsuarios(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuarios")
    public ResponseEntity<Map<String, String>> actualizarUsuario(@RequestBody Usuarios usuario) {
        logger.info("Actualizando usuario: " + usuario);
        usuariosServicio.actualizarUsuarios(usuario);

        // Crear un JSON de respuesta
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario actualizado exitosamente");

        return ResponseEntity.ok(response); // Retorna un JSON válido
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios usuario) {
        Usuarios usuarioAutenticado = usuariosServicio.autenticarUsuario(usuario.getUsuario(), usuario.getPassword());

        if (usuarioAutenticado != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Login exitoso");
            response.put("usuario", usuarioAutenticado);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }
}