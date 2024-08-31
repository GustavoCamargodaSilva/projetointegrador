package projetointegrador.controleestoque.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import projetointegrador.controleestoque.entities.Produto;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo descrição é obrigatório")
    private String descricao;
    @NotNull(message = "O campo preço é obrigatório")
    private Double preco;
    private Integer quantidade;
    @NotNull(message = "O campo categoria é obrigatório")
    private CategoriaDTO categoria;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, Integer quantidade, CategoriaDTO categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.quantidade = produto.getQuantidade();
        this.categoria = new CategoriaDTO(produto.getCategoria());
    }
}
