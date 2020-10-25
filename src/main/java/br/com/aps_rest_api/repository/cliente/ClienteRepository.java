package br.com.aps_rest_api.repository.cliente;

import br.com.aps_rest_api.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmailAndSenha(String username, String senha);
}
