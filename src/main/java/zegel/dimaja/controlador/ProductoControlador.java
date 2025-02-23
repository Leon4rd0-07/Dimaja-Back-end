package zegel.dimaja.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zegel.dimaja.modelo.Productos;
import zegel.dimaja.servicio.ProductoServicio;

import java.util.List;

//1. Indicar que es un controlador REST
@RestController
//2. Desplegar -- Mostrar en la web los datos
// http:localhost:8080/dimaja-app
@RequestMapping("dimaja-app") //Acceder al proyecto
//3. La url para la petición desde angular
@CrossOrigin(value = "http://localhost:4200")

public class ProductoControlador {
    //1. para mostrar mensajes en la consola
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    //2. Inyectar dependencia
    @Autowired
    private ProductoServicio productoServicio;

    // http:localhost:8080/dimaja-app/productos
    //Establecer una Url para el listado de productos
    @GetMapping("/productos")
    public List<Productos> obtenerProductos(){
        //a. Traer la lista de productos
        List<Productos> productos = this.productoServicio.listarProductos();
        //Mostrar en pantalla
        logger.info("Listado de Productos");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    // http:localhost:8080/dimaja-app/productos
    // Endpoint para guardar un nuevo producto
    @PostMapping("/productos")
    public Productos guardarProducto(@RequestBody Productos producto) {
        logger.info("Producto recibido: " + producto);
        Productos productoGuardado = productoServicio.guardarProducto(producto);
        logger.info("Producto guardado: " + productoGuardado.toString());
        return productoGuardado; // Devuelve el objeto JSON
    }

    @GetMapping("/productos/{id}")
    public Productos obtenerProductoPorId(@PathVariable Integer id) {
        logger.info("Buscando producto con ID: " + id);
        return productoServicio.buscarProductoId(id);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/productos")
    public String actualizarProducto(@RequestBody Productos producto) {
        logger.info("Actualizando producto: " + producto);
        productoServicio.actualizarProducto(producto);
        return "Producto actualizado exitosamente";
    }
}
