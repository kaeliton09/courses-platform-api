package dev.kaeliton.courses_platform_api.Services;

import dev.kaeliton.courses_platform_api.DTOs.CursoDTO;
import dev.kaeliton.courses_platform_api.Mappers.CursoMapper;
import dev.kaeliton.courses_platform_api.Models.CursoModel;
import dev.kaeliton.courses_platform_api.Repositorys.CursoRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final MapperBuilder mapperBuilder;
    private CursoRepository cursoRepository;
    private CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper, MapperBuilder mapperBuilder) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
        this.mapperBuilder = mapperBuilder;
    }

    // listar todos os cursos
    public List<CursoDTO> listarCursos(){
        List<CursoModel> cursos = cursoRepository.findAll();
        return cursos.stream()
                .map(cursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // listar curso por id
    public CursoDTO listarCursoPorId(Long id){
        CursoModel curso = cursoRepository.findById(id).orElse(null);;
        if(curso != null){
            return cursoMapper.toDTO(curso);
        }
        return null;
    }

    // criar curso
    public CursoDTO criarCurso(CursoDTO cursoDTO){
        CursoModel novoCurso = cursoMapper.toModel(cursoDTO);
        CursoModel cursoSalvo = cursoRepository.save(novoCurso);
        return cursoMapper.toDTO(cursoSalvo);
    }

    // deletar curso por id
    public void deletarCursoPorId(Long id){
        cursoRepository.deleteById(id);
    }

    // alterar curso por id
    public CursoDTO alterarCursoPorId(Long id, CursoDTO cursoDTO){
        CursoModel cursoExistente = cursoRepository.findById(id).orElse(null);;
        if(cursoExistente != null){

            cursoExistente.setId(cursoDTO.getId());
            cursoExistente.setTitulo(cursoDTO.getTitulo());
            cursoExistente.setDescricao(cursoDTO.getDescricao());
            cursoExistente.setNivel(cursoDTO.getNivel());
            cursoExistente.setTotalAulas(cursoDTO.getTotalAulas());
            cursoExistente.setTotalHoras(cursoDTO.getTotalHoras());

            CursoModel cursoAtualizado = cursoRepository.save(cursoExistente);
            return cursoMapper.toDTO(cursoAtualizado);
        }
        return null;
    }
}
