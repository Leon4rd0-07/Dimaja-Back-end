package zegel.dimaja.servicio;

import zegel.dimaja.modelo.Situacion;

import java.util.List;

public interface ISituacionServicio {
    public List<Situacion> listarSituacion();
    public Situacion buscarSituacionId(Integer idsituacion);
    public Situacion guardarSituacion (Situacion situacion);
}
