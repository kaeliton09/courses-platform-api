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

import dev.kaeliton.courses_platform_api.DTOs.UserDTO;
import dev.kaeliton.courses_platform_api.Services.UserService;




@RestController
@RequestMapping("/usuarios")
public class UserController {


    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public List<UserDTO> listarUsuarios() {
        return userService.listarUsuarios();
    }
    
    @GetMapping("/listar/{id}")
    public UserDTO listarUsuarioPorId(@PathVariable Long id) {
        return userService.listarUsuarioPorId(id);
    }

    @PostMapping("/criar")
    public UserDTO criarUsuario(@RequestBody UserDTO userDTO) {
        return userService.criarUsuario(userDTO);
    }
    
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
    }

    @PutMapping("/alterar/{id}")
    public UserDTO atualizarUsuario(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.atualizarUsuario(id, userDTO);
    }
}