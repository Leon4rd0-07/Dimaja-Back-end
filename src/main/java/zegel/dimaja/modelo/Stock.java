package zegel.dimaja.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    Integer id_productos;

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

    public Integer getId_productos() {
        return id_productos;
    }

    public void setId_productos(Integer id_productos) {
        this.id_productos = id_productos;
    }
}
