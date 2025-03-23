package zegel.dimaja.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//1. Agregando Notaciones
@Entity
@Data
/// Getter Setter
@NoArgsConstructor  //Sin argumentos
@AllArgsConstructor //Con todos los argumentos
@ToString           //ToString
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_productos;
    String nombres_productos;
    String img;
    String marca;
    Double valor_compra;
    Double valor_venta;
    Integer id_categorias;

    public Integer getId_productos() {
        return id_productos;
    }

    public void setId_productos(Integer id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombres_productos() {
        return nombres_productos;
    }

    public void setNombres_productos(String nombres_productos) {
        this.nombres_productos = nombres_productos;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public Integer getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(Integer id_categorias) {
        this.id_categorias = id_categorias;
    }
}
