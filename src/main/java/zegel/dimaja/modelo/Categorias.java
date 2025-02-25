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
@NoArgsConstructor //Sin argumentos
@AllArgsConstructor //Con todos los argumentos
@ToString  //ToString

public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_categorias;
    String nombre_categoria;

    public Integer getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(Integer id_categorias) {
        this.id_categorias = id_categorias;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}
