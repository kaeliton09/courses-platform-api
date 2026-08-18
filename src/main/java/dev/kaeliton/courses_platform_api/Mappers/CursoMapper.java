package dev.kaeliton.courses_platform_api.Mappers;

import dev.kaeliton.courses_platform_api.DTOs.CursoDTO;
import dev.kaeliton.courses_platform_api.Models.CursoModel;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoDTO toDTO(CursoModel cursoModel){

        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(cursoModel.getId());
        cursoDTO.setTitulo(cursoModel.getTitulo());
        cursoDTO.setDescricao(cursoModel.getDescricao());
        cursoDTO.setNivel(cursoModel.getNivel());
        cursoDTO.setTotalAulas(cursoModel.getTotalAulas());
        cursoDTO.setTotalHoras(cursoModel.getTotalHoras());

        return cursoDTO;
    }

    public CursoModel toModel(CursoDTO cursoDTO){

        CursoModel cursoModel = new CursoModel();

        cursoModel.setId(cursoDTO.getId());
        cursoModel.setTitulo(cursoDTO.getTitulo());
        cursoModel.setDescricao(cursoDTO.getDescricao());
        cursoModel.setNivel(cursoDTO.getNivel());
        cursoModel.setTotalAulas(cursoDTO.getTotalAulas());
        cursoModel.setTotalHoras(cursoDTO.getTotalHoras());

        return cursoModel;
    }
}
