package br.com.aps_rest_api.repository.pedido;

import br.com.aps_rest_api.model.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    @Query(value = "select * from pedido where idcliente = ?1",nativeQuery = true)
    List<Pedido> buscaPedidoByCliente(Long idCliente);

}
