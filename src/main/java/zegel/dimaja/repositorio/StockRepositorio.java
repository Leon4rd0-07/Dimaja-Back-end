package zegel.dimaja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Stock;

public interface StockRepositorio extends JpaRepository <Stock, Integer> {
}
