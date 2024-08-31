package projetointegrador.controleestoque.projection;

import lombok.Getter;
import projetointegrador.controleestoque.entitie.Categoria;

public interface CategoriaProjection {

    Long getId();
    String getNome();
    String getDescricao();

}
