package dev.kaeliton.courses_platform_api.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.kaeliton.courses_platform_api.DTOs.CategoriaDTO;
import dev.kaeliton.courses_platform_api.Mappers.CategoriaMapper;
import dev.kaeliton.courses_platform_api.Models.CategoriaModel;
import dev.kaeliton.courses_platform_api.Repositorys.CategoriaRpository;

@Service
public class CategoriaService {


    private CategoriaRpository categoriaRpository;
    private CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRpository categoriaRpository, CategoriaMapper categoriaMapper) {
        this.categoriaRpository = categoriaRpository;
        this.categoriaMapper = categoriaMapper;
    }

    //listar todas as categorias
    public List<CategoriaDTO> listarCategorias() {
        List<CategoriaModel> categorias = categoriaRpository.findAll();
        return categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    //listar categoria por id
    public CategoriaDTO listarCategoriaPorId(Long id) {
        CategoriaModel categoria = categoriaRpository.findById(id).orElse(null);
        if (categoria != null) {
            return categoriaMapper.toDTO(categoria);
        }
        return null;
    }

    //criar categoria
    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = categoriaMapper.toModel(categoriaDTO);
        CategoriaModel categoriaSalva = categoriaRpository.save(categoriaModel);
        return categoriaMapper.toDTO(categoriaSalva);
    }

    //deletar categoria
    public void deletarCategoria(Long id) {
        categoriaRpository.deleteById(id);
    }

    //atualizar categoria
    public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaExistente = categoriaRpository.findById(id).orElse(null);
        if (categoriaExistente != null) {
            categoriaExistente.setId(id);
            categoriaExistente.setNome(categoriaDTO.getNome());
            categoriaExistente.setDescricao(categoriaDTO.getDescricao());
            CategoriaModel categoriaAtualizada = categoriaRpository.save(categoriaExistente);
            return categoriaMapper.toDTO(categoriaAtualizada);
        }
        return null;
    }

}


