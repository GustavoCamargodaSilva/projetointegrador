package projetointegrador.controleestoque.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projetointegrador.controleestoque.dto.CategoriaDTO;
import projetointegrador.controleestoque.projection.CategoriaProjection;
import projetointegrador.controleestoque.service.CategoriaService;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listarcategorias")
    public ResponseEntity<List<CategoriaProjection>> listarCategorias(){
        List<CategoriaProjection> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @PostMapping("/cadastrarcategoria")
    public ResponseEntity<CategoriaDTO> cadastrarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = categoriaService.cadastrarCategoria(categoriaDTO);
        return ResponseEntity.ok().body(categoria);
    }

    @PutMapping("/atualizarcategoria")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = categoriaService.atualizarCategoria(categoriaDTO);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/deletarcategoria/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
