package zegel.dimaja.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Situacion;
import zegel.dimaja.repositorio.SituacionRepositorio;

import java.util.List;

@Service
public class SituacionServicio implements ISituacionServicio{
    @Autowired
    private SituacionRepositorio situacionRepositorio;

    @Override
    public List<Situacion> listarSituacion() {
        List<Situacion> situacion = this.situacionRepositorio.findAll();
        return situacion;
    }

    @Override
    public Situacion buscarSituacionId(Integer idsituacion) {
        Situacion situacion = this.situacionRepositorio.findById(idsituacion).orElse(null);
        return null;
    }

    @Override
    public Situacion guardarSituacion(Situacion situacion) {
        return this.situacionRepositorio.save(situacion);
    }
}
