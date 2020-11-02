package br.com.aps_rest_api.repository.carrinho;

import br.com.aps_rest_api.model.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    @Query(value = "select * from carrinho where idcliente = ?1 order by idcarrinho",nativeQuery = true)
    List<Carrinho> findByIdCliente(Long idCliente);

    @Query(value = "select * from carrinho where idcliente = ?1 and idCarrinho = ?2 order by idcarrinho",nativeQuery = true)
    Carrinho findByIdClienteAndIdCarrinho(Long idCliente, Long idCarrinho);

    @Query(value = "select sum(c.quantidade * p.preco) " +
            " from carrinho c, produto p " +
            " where c.idproduto = p.idproduto " +
            " and c.idcliente = ?1",nativeQuery = true)
    Double getValorTotalCarrinhoByIdCliente(Long idCliente);

    @Modifying
    @Transactional
    @Query(value ="delete from carrinho where idcliente = ?1",nativeQuery = true)
    void deleteCarrinhoByCliente(Long idCliente);
}
