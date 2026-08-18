package dev.kaeliton.courses_platform_api.Controllers;

import dev.kaeliton.courses_platform_api.DTOs.CursoDTO;
import dev.kaeliton.courses_platform_api.Services.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/listar")
    public List<CursoDTO> listarCursos(){
        return cursoService.listarCursos();
    }

    @GetMapping("/listar/{id}")
    public CursoDTO listarCursoPorId(@PathVariable Long id){
        return cursoService.listarCursoPorId(id);
    }

    @PostMapping("/criar")
    public CursoDTO criarCurso(@RequestBody CursoDTO curso){
        return cursoService.criarCurso(curso);
    }

    @PutMapping("/alterar/{id}")
    public CursoDTO alterarCursoPorId(@PathVariable Long id, @RequestBody CursoDTO curso){
        return cursoService.alterarCursoPorId(id, curso);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCursoPorId(@PathVariable Long id){
        cursoService.deletarCursoPorId(id);
    }
}
