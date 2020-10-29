package br.com.aps_rest_api.repository.produto;

import br.com.aps_rest_api.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "select * from produto p, categoria c " +
            " where p.idcategoria = c.idcategoria" +
            " and c.idcategoria = ?1 ",nativeQuery = true)
    List<Produto> buscaProdutoCategoria(Long idCategoria);

}
