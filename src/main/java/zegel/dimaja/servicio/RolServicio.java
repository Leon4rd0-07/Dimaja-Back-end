package zegel.dimaja.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Rol;
import zegel.dimaja.repositorio.RolRepositorio;

import java.util.List;

//Implementa los detalles de los metodos
//descritos de la interface

//1. Indicar que la clase es un Servicio
@Service
public class RolServicio implements  IRolServicio{
    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public List<Rol> listarRol() {
        List<Rol> rol = this.rolRepositorio.findAll();
        return rol;
    }

    @Override
    public Rol buscarRolId(Integer idrol) {
        Rol rol = this.rolRepositorio.findById(idrol).orElse(null);
        return null;
    }

    @Override
    public void guardarRol(Rol rol) {
        this.rolRepositorio.save(rol);
    }
}
