package dev.kaeliton.courses_platform_api.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kaeliton.courses_platform_api.DTOs.CategoriaDTO;
import dev.kaeliton.courses_platform_api.Services.CategoriaService;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/criar")
    public CategoriaDTO criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.criarCategoria(categoriaDTO);
    }

    @GetMapping("/listar")
    public List<CategoriaDTO> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/listar/{id}")
    public CategoriaDTO listarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.listarCategoriaPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public CategoriaDTO atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.atualizarCategoria(id, categoriaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }
    
}
