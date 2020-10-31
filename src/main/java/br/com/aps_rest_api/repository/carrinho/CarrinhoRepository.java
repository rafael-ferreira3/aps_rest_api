package br.com.aps_rest_api.repository.carrinho;

import br.com.aps_rest_api.model.carrinho.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
