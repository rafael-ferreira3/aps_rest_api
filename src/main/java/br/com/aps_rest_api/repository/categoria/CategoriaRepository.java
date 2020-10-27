package br.com.aps_rest_api.repository.categoria;

import br.com.aps_rest_api.model.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
