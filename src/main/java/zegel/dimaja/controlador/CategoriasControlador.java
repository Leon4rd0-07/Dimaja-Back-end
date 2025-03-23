package zegel.dimaja.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zegel.dimaja.modelo.Categorias;
import zegel.dimaja.modelo.Rol;
import zegel.dimaja.servicio.CategoriasServicio;

import java.util.List;

//1. Indicar que es un controlador REST
@RestController
//2. Desplegar -- Mostrar en la web los datos
// http:localhost:8080/dimaja-app
@RequestMapping("dimaja-app") //Acceder al proyecto
//3. La url para la petición desde angular
@CrossOrigin(value = "http://localhost:4200")
public class CategoriasControlador {
    //1. para mostrar mensajes en la consola
    private  static final Logger logger = LoggerFactory.getLogger(CategoriasControlador.class);
    //2. Inyectar dependencia
    @Autowired
    private CategoriasServicio categoriasServicio;
    // http:localhost:8080/dimaja-app/categorias
    //Establecer una Url para el listado de categorias
    @GetMapping("/categorias")
    public List<Categorias> obtenerCategoias(){
        //a. Traer la lista de Categorias
        List<Categorias> categorias = this.categoriasServicio.listarCategorias();
        //Mostrar en pantalla
        logger.info("Listado de Categorias");
        categorias.forEach((categoria -> logger.info(categoria.toString())));
        return categorias;
    }

    @PostMapping("/categorias")
    public Categorias guardarCategorias(@RequestBody Categorias categorias) {
        logger.info("Categoria recibido: " + categorias);
        Categorias categoriaGuardado = categoriasServicio.guardarCategorias(categorias);
        logger.info("Categoria guardado: " + categoriaGuardado);
        return categoriaGuardado;
    }
}
