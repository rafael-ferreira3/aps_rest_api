package br.com.aps_rest_api.service.categoria;

import br.com.aps_rest_api.model.categoria.Categoria;
import br.com.aps_rest_api.service.helpers.UrlConstant;
import br.com.aps_rest_api.endpoint.categoria.CategoriaParam;
import br.com.aps_rest_api.endpoint.categoria.CategoriaQuery;
import br.com.aps_rest_api.repository.categoria.CategoriaRepository;
import br.com.aps_rest_api.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void cadastraCategoria(CategoriaParam categoriaParam) {
        categoriaRepository.save(makeCategoria(categoriaParam));
    }

    @Override
    public List<CategoriaQuery> buscaCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return makeListCategoriaQuery(categorias);
    }

    @Override
    public String getCategoriaImg(java.lang.Long idLong) {
        Optional<Categoria> categoria = categoriaRepository.findById(idLong);
        if(!categoria.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Categoria ID: "+ idLong +" não encontrado");
        }
        return categoria.get().getImg();
    }

    @Override
    public CategoriaQuery atualizaCategoria(CategoriaParam categoriaParam) {

        return makeCategoriaQuery(atualizarCategoria(categoriaParam));
    }

    @Override
    public void deletarCategoria(java.lang.Long idLong) {
        Optional<Categoria> categoria = categoriaRepository.findById(idLong);
        if(!categoria.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Categoria ID: "+ idLong +" não encontrado");
        }
        categoriaRepository.delete(categoria.get());
    }

    private Categoria atualizarCategoria(CategoriaParam categoriaParam) {

        Optional<Categoria> categoria = categoriaRepository.findById(categoriaParam.getIdCategoria());

        if(!categoria.isPresent()){
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Categoria ID: "+categoriaParam.getIdCategoria()+" não encontrado");
        }

        Categoria categoriaAtualizar = categoria.get();

        categoriaAtualizar.setIdCategoria( categoriaParam.getIdCategoria());

        if(categoriaParam.getDescr() != null){
            categoriaAtualizar.setDescricao(categoriaParam.getDescr());
        }

        if(categoriaParam.getImg() != null){
            categoriaAtualizar.setImg(categoriaParam.getImg());
        }

        return categoriaRepository.save(categoriaAtualizar);

    }

    private Categoria makeCategoria(CategoriaParam categoriaParam){
        return new Categoria(categoriaParam.getIdCategoria(), categoriaParam.getDescr(),categoriaParam.getImg());
    }

    private String makeImgLink(java.lang.Long idLong){
        return UrlConstant.URL+"/api/categoria/img/"+ idLong;
    }

    private CategoriaQuery makeCategoriaQuery(Categoria categoria){
        return new CategoriaQuery(categoria.getIdCategoria(), categoria.getDescricao(),makeImgLink(categoria.getIdCategoria()));
    }

    private List<CategoriaQuery> makeListCategoriaQuery(List<Categoria> categorias){
        List<CategoriaQuery> categoriaQueries = new ArrayList<>();
        for(Categoria categoria : categorias){
            categoriaQueries.add(makeCategoriaQuery(categoria));
        }
        return categoriaQueries;
    }

}
