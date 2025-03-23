package zegel.dimaja.servicio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Stock;
import zegel.dimaja.repositorio.StockRepositorio;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StockServicio implements IStockServicio {

    private static final Logger logger = LoggerFactory.getLogger(StockServicio.class);

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

        try {
            if (stockExistente != null) {
                stockExistente.setCantidad(stockExistente.getCantidad() + cantidad);
                return stockRepositorio.save(stockExistente); // Intentamos guardar el stock actualizado
            } else {
                Stock nuevoStock = new Stock();
                nuevoStock.setIdProductos(idProducto);
                nuevoStock.setCantidad(cantidad);
                return stockRepositorio.save(nuevoStock); // Intentamos guardar el nuevo stock
            }
        } catch (ObjectOptimisticLockingFailureException e) {
            // Maneja el error de concurrencia optimista
            logger.error("La fila fue actualizada por otro proceso, intente nuevamente.", e);
            // Puedes lanzar una excepción personalizada o devolver un valor de error si lo deseas
            return null; // O el manejo que prefieras
        } catch (DataAccessException e) {
            // Aquí puedes manejar otros errores de acceso a la base de datos si fuera necesario
            logger.error("Error al acceder a la base de datos: ", e);
            return null; // O el manejo que prefieras
        }
    }

    // Método para agregar múltiples productos y sus cantidades
    @Transactional
    public List<Stock> agregarMultipleStock(List<Stock> productosStock) {
        List<Stock> productosAgregados = new ArrayList<>();
        for (Stock stock : productosStock) {
            try {
                // Verifica si el producto ya existe en la base de datos
                Stock stockExistente = stockRepositorio.findByIdProductos(stock.getIdProductos());
                if (stockExistente != null) {
                    // Si existe, actualiza la cantidad
                    stockExistente.setCantidad(stockExistente.getCantidad() + stock.getCantidad());
                    Stock stockActualizado = stockRepositorio.save(stockExistente);
                    productosAgregados.add(stockActualizado); // Agrega el stock actualizado a la lista
                    logger.info("Stock actualizado: " + stockActualizado);
                } else {
                    // Si no existe, agrega un nuevo producto
                    Stock nuevoStock = stockRepositorio.save(stock);
                    productosAgregados.add(nuevoStock); // Agrega el nuevo stock a la lista
                    logger.info("Nuevo stock agregado: " + nuevoStock);
                }
            } catch (DataIntegrityViolationException e) {
                // Maneja errores de violación de integridad (ej. duplicados, restricciones de la base de datos)
                logger.error("Error de integridad al acceder a la base de datos: ", e);
            } catch (Exception e) {
                // Maneja otros errores de acceso a la base de datos
                logger.error("Error inesperado al acceder a la base de datos: ", e);
            }
        }
        return productosAgregados; // Devuelve la lista de productos agregados o actualizados
    }
}
