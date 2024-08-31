package projetointegrador.controleestoque.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import projetointegrador.controleestoque.entitie.Categoria;
import projetointegrador.controleestoque.entitie.Produto;

import java.util.List;

@Getter
@Setter
public class CategoriaDTO {

    private Long id;
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo descrição é obrigatório")
    private String descricao;

    private List<ProdutoDTO> produtos;

    public CategoriaDTO() { }

    public CategoriaDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        for(Produto produto : categoria.getProdutos()) {
            this.produtos.add(new ProdutoDTO(produto));
        }
    }
}
