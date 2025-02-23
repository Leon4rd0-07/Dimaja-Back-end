package zegel.dimaja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol,Integer> {
}
