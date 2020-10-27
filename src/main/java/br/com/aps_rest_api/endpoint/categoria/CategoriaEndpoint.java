package br.com.aps_rest_api.endpoint.categoria;

import br.com.aps_rest_api.service.categoria.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api("Api de Categoria")
@CrossOrigin(origins = "*")
public class CategoriaEndpoint {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/categoria")
    @ApiOperation("Cadastra uma nova categoria")
    public void cadastraCategoria(@RequestBody CategoriaParam categoriaParam){
        categoriaService.cadastraCategoria(categoriaParam);
    }

    @GetMapping("/categorias")
    @ApiOperation("Lista todas as categorias")
    public List<CategoriaQuery> buscaCategorias(){
        return categoriaService.buscaCategorias();
    }

    @GetMapping("categoria/img/{idCategoria}")
    @ApiOperation("Busca a Imagem da Categoria")
    public String buscaCategoriaImg(@PathVariable Long idCategoria){
        return categoriaService.getCategoriaImg(idCategoria);
    }



}
