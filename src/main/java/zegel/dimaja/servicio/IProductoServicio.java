package zegel.dimaja.servicio;

import zegel.dimaja.modelo.Productos;
import java.util.List;

//Aqui vamos a describir las acciones a realizar en los productos
public interface IProductoServicio {
    List<Productos> listarProductos();
    Productos buscarProductoId(Integer idProducto);
    Productos guardarProducto(Productos producto); // 🔹 Cambié void por Productos
    void eliminarProducto(Integer idProducto);
    void actualizarProducto(Productos producto);
}
