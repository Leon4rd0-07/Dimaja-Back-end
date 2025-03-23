package zegel.dimaja.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Usuarios;
import zegel.dimaja.repositorio.UsuariosRepositorio;

import java.util.List;
import java.util.Optional;

//Implementa los detalles de los metodos
//descritos de la interface

//1. Indicar que la clase es un Servicio
@Service
public class UsuariosServicio implements IUsuariosServicio{
    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    @Override
    public Usuarios autenticarUsuario(String usuario, String password) {
        Optional<Usuarios> usuarioEncontrado = usuariosRepositorio.findByUsuario(usuario);

        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getPassword().equals(password)) {
            return usuarioEncontrado.get(); // Usuario autenticado con éxito
        }
        return null; // Usuario no encontrado o contraseña incorrecta
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        List<Usuarios> usuarios = this.usuariosRepositorio.findAll();
        return usuarios;
    }

    @Override
    public Usuarios buscarUsuariosId(Integer idusuarios) {
        Usuarios usuarios = this.usuariosRepositorio.findById(idusuarios).orElse(null);
        return usuarios;
    }

    @Override
    public Usuarios guardarUsuarios(Usuarios usuarios) {
        return this.usuariosRepositorio.save(usuarios);
    }

    @Override
    public void eliminarUsuarios(Integer idusuarios) {
        this.usuariosRepositorio.deleteById(idusuarios);
    }

    @Override
    public void actualizarUsuarios(Usuarios usuarios) {
        if (usuariosRepositorio.existsById(usuarios.getId_usuarios())) {
            usuariosRepositorio.save(usuarios);
        }
    }
}