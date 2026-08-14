package dev.kaeliton.courses_platform_api.Mappers;

import org.springframework.stereotype.Component;

import dev.kaeliton.courses_platform_api.DTOs.CategoriaDTO;
import dev.kaeliton.courses_platform_api.Models.CategoriaModel;

@Component
public class CategoriaMapper {

    public CategoriaModel toModel(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(categoriaDTO.getId());
        categoriaModel.setNome(categoriaDTO.getNome());
        categoriaModel.setDescricao(categoriaDTO.getDescricao());
        return categoriaModel;
    }

    public CategoriaDTO toDTO(CategoriaModel categoriaModel) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoriaModel.getId());
        categoriaDTO.setNome(categoriaModel.getNome());
        categoriaDTO.setDescricao(categoriaModel.getDescricao());
        return categoriaDTO;
    }
}
