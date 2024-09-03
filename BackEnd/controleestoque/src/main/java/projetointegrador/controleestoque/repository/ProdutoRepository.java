package projetointegrador.controleestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetointegrador.controleestoque.entitie.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p JOIN FETCH p.categoria")
    List<Produto> buscarProdutos();
}
