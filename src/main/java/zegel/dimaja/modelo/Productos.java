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
    Double precio;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(Integer id_categorias) {
        this.id_categorias = id_categorias;
    }
}
