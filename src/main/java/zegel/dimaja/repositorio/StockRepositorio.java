package zegel.dimaja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Stock;

public interface StockRepositorio extends JpaRepository<Stock, Integer> {
    Stock findByIdProductos(Integer idProductos); // Debe coincidir con el nombre en la entidad
}



