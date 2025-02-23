package zegel.dimaja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Categorias;

//Ahora si  Acciones "registrar, eliminar, consultar" -- Producto
public interface CategoriasRepositorio extends JpaRepository <Categorias, Integer> {
}
