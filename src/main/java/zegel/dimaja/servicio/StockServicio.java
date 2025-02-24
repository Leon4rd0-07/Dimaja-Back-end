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
        Stock stockExistente = stockRepositorio.findByIdProductos(idProducto); // Ya corregido

        if (stockExistente != null) {
            stockExistente.setCantidad(stockExistente.getCantidad() + cantidad);
            return stockRepositorio.save(stockExistente);
        } else {
            Stock nuevoStock = new Stock();
            nuevoStock.setIdProductos(idProducto); // CAMBIO aquí también
            nuevoStock.setCantidad(cantidad);
            return stockRepositorio.save(nuevoStock);
        }
    }
}
