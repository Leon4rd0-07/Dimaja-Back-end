package zegel.dimaja.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
/// Getter Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_stock;
    Integer cantidad;
    @Column(name = "id_productos") // Asegura el mapeo correcto con la BD
    Integer idProductos; // CAMBIAR de id_productos a idProductos

    public Integer getId_stock() {
        return id_stock;
    }

    public void setId_stock(Integer id_stock) {
        this.id_stock = id_stock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }
}
