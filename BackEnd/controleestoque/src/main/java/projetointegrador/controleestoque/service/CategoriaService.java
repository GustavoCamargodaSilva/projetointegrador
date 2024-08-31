package projetointegrador.controleestoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetointegrador.controleestoque.dto.CategoriaDTO;
import projetointegrador.controleestoque.entitie.Categoria;
import projetointegrador.controleestoque.projection.CategoriaProjection;
import projetointegrador.controleestoque.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<CategoriaProjection> listarCategorias() {

        List<CategoriaProjection> cat = categoriaRepository.listarCategorias();
        return cat;
    }

    @Transactional
    public CategoriaDTO cadastrarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }
}
