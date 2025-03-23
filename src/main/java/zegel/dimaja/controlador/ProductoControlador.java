package zegel.dimaja.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zegel.dimaja.modelo.Productos;
import zegel.dimaja.servicio.ProductoServicio;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dimaja-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    // Carpeta donde se guardarán las imágenes (ubicación accesible desde el servidor)
    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/productos")
    public List<Productos> obtenerProductos() {
        List<Productos> productos = productoServicio.listarProductos();
        logger.info("Listado de Productos");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos")
    public Productos guardarProducto(@RequestBody Productos producto) {
        logger.info("Producto recibido: " + producto);
        Productos productoGuardado = productoServicio.guardarProducto(producto);
        logger.info("Producto guardado: " + productoGuardado);
        return productoGuardado;
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
    public ResponseEntity<Map<String, String>> actualizarProducto(@RequestBody Productos producto) {
        logger.info("Actualizando producto: " + producto);
        productoServicio.actualizarProducto(producto);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Producto actualizado exitosamente");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/productos/upload")
    public ResponseEntity<Map<String, String>> subirArchivo(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();
        try {
            if (file.isEmpty()) {
                response.put("error", "El archivo está vacío");
                return ResponseEntity.badRequest().body(response);
            }

            // Asegurar que la carpeta 'uploads/' existe
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Guardar el archivo en la carpeta 'uploads/'
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // Evitar archivos con el mismo nombre
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Generar la URL de acceso
            String fileUrl = "http://localhost:8080/uploads/" + filename;
            response.put("mensaje", "Archivo subido exitosamente");
            response.put("url", fileUrl);
            return ResponseEntity.ok(response);

        } catch (IOException e) {
            logger.error("Error al subir archivo", e);
            response.put("error", "No se pudo subir el archivo");
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
