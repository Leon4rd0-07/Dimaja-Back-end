package zegel.dimaja.servicio;

import zegel.dimaja.modelo.Stock;
import java.util.List;

public interface IStockServicio {
    List<Stock> listarStock();
    Stock buscarStockPorProducto(Integer idProducto);
    Stock agregarStock(Integer idProducto, Integer cantidad);
}
