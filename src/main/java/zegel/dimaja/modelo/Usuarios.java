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
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_usuarios;
    String nombres;
    String correo;
    String usuario;
    String password;
    Integer dni;
    Integer id_rol;
}
