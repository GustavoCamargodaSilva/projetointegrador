package projetointegrador.controleestoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetointegrador.controleestoque.dto.ProdutoDTO;
import projetointegrador.controleestoque.entitie.Categoria;
import projetointegrador.controleestoque.entitie.Produto;
import projetointegrador.controleestoque.repository.CategoriaRepository;
import projetointegrador.controleestoque.repository.ProdutoRepository;
import projetointegrador.controleestoque.service.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.buscarProdutos();
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ProdutoDTO cadastrarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();

        Categoria categoria = categoriaRepository.findByNome(produtoDTO.getNomeCategoria().toLowerCase());

        if (categoria == null) {
           throw new ResourceNotFoundException("Categoria não encontrada");
        }

        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setCategoria(categoria);

        produto = produtoRepository.save(produto);

        return new ProdutoDTO(produto);
    }

    @Transactional
    public ProdutoDTO atualizarProduto(ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.getReferenceById(produtoDTO.getId());
        Categoria categoria = categoriaRepository.findByNome(produtoDTO.getNomeCategoria().toLowerCase());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setCategoria(categoria);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    @Transactional
    public void deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }

    @Transactional(readOnly = true)
    public ProdutoDTO buscarProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return new ProdutoDTO(produto);
    }

}
