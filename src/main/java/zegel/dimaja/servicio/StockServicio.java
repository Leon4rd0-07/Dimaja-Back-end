package zegel.dimaja.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Stock;
import zegel.dimaja.repositorio.StockRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class StockServicio implements IStockServicio {

    @Autowired
    private StockRepositorio stockRepositorio;

    @Override
    public List<Stock> listarStock() {
        return stockRepositorio.findAll();
    }

    @Override
    public Stock buscarStockPorProducto(Integer idProducto) {
        return stockRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public Stock agregarStock(Integer idProducto, Integer cantidad) {
        Optional<Stock> stockExistente = stockRepositorio.findById(idProducto);

        if (stockExistente.isPresent()) {
            Stock stock = stockExistente.get();
            stock.setCantidad(stock.getCantidad() + cantidad); // Sumar al stock actual
            return stockRepositorio.save(stock);
        } else {
            Stock nuevoStock = new Stock();
            nuevoStock.setId_productos(idProducto);
            nuevoStock.setCantidad(cantidad);
            return stockRepositorio.save(nuevoStock);
        }
    }
}
