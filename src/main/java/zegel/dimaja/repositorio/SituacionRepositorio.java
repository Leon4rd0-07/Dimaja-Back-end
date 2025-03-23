package zegel.dimaja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.dimaja.modelo.Situacion;

public interface SituacionRepositorio extends JpaRepository<Situacion, Integer> {
}
