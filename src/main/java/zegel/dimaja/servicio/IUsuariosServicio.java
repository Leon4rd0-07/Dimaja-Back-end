package zegel.dimaja.servicio;

import zegel.dimaja.modelo.Usuarios;

import java.util.List;

//Aqui vamos a describir las acciones
// a realizar a los productos
public interface IUsuariosServicio {
    public List<Usuarios>listarUsuarios();
    public Usuarios buscarUsuariosId(Integer idusuarios);
    Usuarios guardarUsuarios (Usuarios usuarios);
    public void eliminarUsuarios(Integer idusuarios);
    public void actualizarUsuarios(Usuarios usuarios);

    // Método para autenticar usuario
    Usuarios autenticarUsuario(String usuario, String password);
}
