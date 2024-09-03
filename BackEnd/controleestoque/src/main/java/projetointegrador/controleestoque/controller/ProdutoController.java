package projetointegrador.controleestoque.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetointegrador.controleestoque.dto.ProdutoDTO;
import projetointegrador.controleestoque.service.ProdutoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/listarprodutos")
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping(value = "/buscarproduto/{id}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.buscarProduto(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping(value = "/cadastrarproduto")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produto = produtoService.cadastrarProduto(produtoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping(value = "/atualizarproduto")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produto = produtoService.atualizarProduto(produtoDTO);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(value = "/deletarproduto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
