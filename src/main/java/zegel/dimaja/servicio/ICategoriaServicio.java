package zegel.dimaja.servicio;

import zegel.dimaja.modelo.Categorias;

import java.util.List;

//Aqui vamos a describir las accioness
//a realizar a los productos
public interface ICategoriaServicio {
    public List<Categorias> listarCategorias();
    public Categorias buscarCategoriasId(Integer idCategorias);
    public Categorias  guardarCategorias(Categorias categorias);
    public void  eliminarCategorias(Integer idCategorias);
}
