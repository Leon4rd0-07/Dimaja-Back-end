package zegel.dimaja.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Productos;
import zegel.dimaja.repositorio.ProductoRepositorio;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Productos> listarProductos() {
        return this.productoRepositorio.findAll();
    }

    @Override
    public Productos buscarProductoId(Integer idProducto) {
        return this.productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public Productos guardarProducto(Productos producto) { // 🔹 Ahora devuelve Productos
        return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }

    @Override
    public void actualizarProducto(Productos producto) {
        if (productoRepositorio.existsById(producto.getId_productos())) {
            productoRepositorio.save(producto);
        }
    }
}
