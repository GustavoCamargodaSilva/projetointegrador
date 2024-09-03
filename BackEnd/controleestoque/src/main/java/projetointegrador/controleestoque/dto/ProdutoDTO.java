package projetointegrador.controleestoque.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import projetointegrador.controleestoque.entitie.Produto;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo descrição é obrigatório")
    private String descricao;
    @NotNull(message = "O campo quantidade é obrigatório")
    private Integer quantidade;
    @NotNull(message = "O campo categoria é obrigatório")
    private String nomeCategoria;

    public ProdutoDTO() { }

    public ProdutoDTO(Long id, String nome, String descricao, Integer quantidade, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.nomeCategoria = categoria;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.quantidade = produto.getQuantidade();
        this.nomeCategoria = produto.getCategoria().getNome();
    }
}
