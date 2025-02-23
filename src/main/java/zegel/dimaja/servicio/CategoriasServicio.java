package zegel.dimaja.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.dimaja.modelo.Categorias;
import zegel.dimaja.repositorio.CategoriasRepositorio;

import java.util.List;

//Implementa los detalles de los metodos
//descritos de la interface

//1. Indicar que la clase es un Servicio
@Service
public class CategoriasServicio implements ICategoriaServicio{
    @Autowired
    private CategoriasRepositorio categoriasRepositorio;
    @Override
    public List<Categorias> listarCategorias() {
        List<Categorias> categorias  = this.categoriasRepositorio.findAll();
        return categorias;
    }

    @Override
    public Categorias buscarCategoriasId(Integer idCategorias) {
        Categorias categorias = this.categoriasRepositorio.findById(idCategorias).orElse(null);
        return categorias;
    }

    @Override
    public void guardarCategorias(Categorias categorias) {
        this.categoriasRepositorio.save(categorias);

    }

    @Override
    public void eliminarCategorias(Integer idCategorias) {
        this.categoriasRepositorio.deleteById(idCategorias);

    }
}
