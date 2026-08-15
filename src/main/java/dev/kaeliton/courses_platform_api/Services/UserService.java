package dev.kaeliton.courses_platform_api.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.kaeliton.courses_platform_api.DTOs.UserDTO;
import dev.kaeliton.courses_platform_api.Mappers.UserMappper;
import dev.kaeliton.courses_platform_api.Models.UserModel;
import dev.kaeliton.courses_platform_api.Repositorys.UserRepository;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMappper userMapper;

    public UserService(UserRepository userRepository, UserMappper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    //listar todos os usuários
    public List<UserDTO> listarUsuarios() {
        List<UserModel> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    //listar usuário por id
    public UserDTO listarUsuarioPorId(Long id) {
        UserModel usuario = userRepository.findById(id).orElse(null);
        return usuario != null ? userMapper.toDTO(usuario) : null;
    }

    //criar usuário
    public UserDTO criarUsuario(UserDTO userDTO) {
        UserModel userModel = userMapper.toModel(userDTO);
        UserModel usuarioSalvo = userRepository.save(userModel);
        return userMapper.toDTO(usuarioSalvo);
    }

    //deletar usuário
    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    //atualizar usuário
    public UserDTO atualizarUsuario(Long id, UserDTO userDTO) {
        UserModel usuarioExistente = userRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setId(id);
            usuarioExistente.setNome(userDTO.getNome());
            usuarioExistente.setEmail(userDTO.getEmail());
            usuarioExistente.setSenha(userDTO.getSenha());
            UserModel usuarioAtualizado = userRepository.save(usuarioExistente);
            return userMapper.toDTO(usuarioAtualizado);
        }
        return null;
    }

}