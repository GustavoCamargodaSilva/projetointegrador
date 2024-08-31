package projetointegrador.controleestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetointegrador.controleestoque.entitie.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
