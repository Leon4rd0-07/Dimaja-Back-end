package zegel.dimaja.servicio;

import zegel.dimaja.modelo.Rol;

import java.util.List;

//Aqui vamos a describir las acciones
// a realizar a los productos
public interface IRolServicio {
    public List<Rol>listarRol();
    public Rol buscarRolId(Integer idrol);
    public Rol guardarRol (Rol rol);
}
