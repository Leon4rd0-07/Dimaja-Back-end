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
@Data /// Getter Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Situacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_situacion;
    String nombre_situacion;

    public Integer getId_situacion() {
        return id_situacion;
    }

    public void setId_situacion(Integer id_situacion) {
        this.id_situacion = id_situacion;
    }

    public String getNombre_situacion() {
        return nombre_situacion;
    }

    public void setNombre_situacion(String nombre_situacion) {
        this.nombre_situacion = nombre_situacion;
    }

}
