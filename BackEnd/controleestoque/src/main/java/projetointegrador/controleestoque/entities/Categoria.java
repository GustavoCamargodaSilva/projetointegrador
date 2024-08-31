package projetointegrador.controleestoque.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private Set<Produto> produtos = new HashSet<>();

    public Categoria() { }

    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

}
