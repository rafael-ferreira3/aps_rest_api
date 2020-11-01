package br.com.aps_rest_api.repository.carrinho;

import br.com.aps_rest_api.model.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    @Query(value = "select * from carrinho where idcliente = ?1",nativeQuery = true)
    List<Carrinho> findByIdCliente(Long idCliente);

}
