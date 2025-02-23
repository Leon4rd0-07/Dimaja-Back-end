package zegel.dimaja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Productos;

//Ahora si  Acciones "registrar, eliminar, consultar" -- Producto
public interface ProductoRepositorio extends JpaRepository <Productos, Integer> {
}
