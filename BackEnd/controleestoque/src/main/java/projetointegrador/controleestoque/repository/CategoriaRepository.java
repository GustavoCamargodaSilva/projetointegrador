package projetointegrador.controleestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetointegrador.controleestoque.entitie.Categoria;
import projetointegrador.controleestoque.projection.CategoriaProjection;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c")
    List<CategoriaProjection> listarCategorias();

    Categoria findByNome(String nome);
}
