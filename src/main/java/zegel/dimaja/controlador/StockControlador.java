package zegel.dimaja.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zegel.dimaja.modelo.Stock;
import zegel.dimaja.servicio.StockServicio;

import java.util.List;

@RestController
@RequestMapping("dimaja-app")
@CrossOrigin(value = "http://localhost:4200")
public class StockControlador {

    private static final Logger logger = LoggerFactory.getLogger(StockControlador.class);

    @Autowired
    private StockServicio stockServicio;

    @GetMapping("/stock")
    public List<Stock> obtenerStock() {
        List<Stock> stock = stockServicio.listarStock();
        logger.info("Listado de Stock:");
        stock.forEach(stocks -> logger.info(stocks.toString()));
        return stock;
    }

    @GetMapping("/stock/{idProducto}")
    public ResponseEntity<Stock> obtenerStockPorProducto(@PathVariable Integer idProducto) {
        Stock stock = stockServicio.buscarStockPorProducto(idProducto);
        return (stock != null) ? ResponseEntity.ok(stock) : ResponseEntity.notFound().build();
    }

    @PostMapping("/stock")
    public ResponseEntity<Stock> agregarStock(@RequestBody Stock stock) {
        logger.info("Recibiendo stock: " + stock);
        Stock stockActualizado = stockServicio.agregarStock(stock.getIdProductos(), stock.getCantidad());
        return ResponseEntity.ok(stockActualizado);
    }

    // Nuevo endpoint para agregar múltiples productos de stock
    @PostMapping("/stock/multiple")
    public ResponseEntity<List<Stock>> agregarMultipleStock(@RequestBody List<Stock> productosStock) {
        logger.info("Recibiendo múltiples productos de stock: ");
        productosStock.forEach(producto -> logger.info(producto.toString()));

        // Llamar al servicio para agregar los productos
        List<Stock> productosAgregados = stockServicio.agregarMultipleStock(productosStock);

        // Si se agregaron los productos, devuelve la lista de productos agregados
        return ResponseEntity.ok(productosAgregados);  // Devuelve los productos agregados en la respuesta
    }
}
