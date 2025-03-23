package zegel.dimaja.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Usuarios;

public interface UsuariosRepositorio extends JpaRepository<Usuarios,Integer> {
    Optional<Usuarios> findByUsuario(String usuario);
}
