package br.com.aps_rest_api.service.categoria;


import br.com.aps_rest_api.endpoint.categoria.CategoriaParam;
import br.com.aps_rest_api.endpoint.categoria.CategoriaQuery;

import java.util.List;

public interface CategoriaService {

    void cadastraCategoria(CategoriaParam categoriaParam);

    List<CategoriaQuery> buscaCategorias();

    String getCategoriaImg(Long idCategoria);

}
