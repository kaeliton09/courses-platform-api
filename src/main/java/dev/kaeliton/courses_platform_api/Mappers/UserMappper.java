package dev.kaeliton.courses_platform_api.Mappers;

import org.springframework.stereotype.Component;

import dev.kaeliton.courses_platform_api.DTOs.UserDTO;
import dev.kaeliton.courses_platform_api.Models.UserModel;

@Component
public class UserMappper {

    public UserModel toModel(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setNome(userDTO.getNome());
        userModel.setEmail(userDTO.getEmail());
        userModel.setSenha(userDTO.getSenha());
        return userModel;
    }

    public UserDTO toDTO(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setNome(userModel.getNome());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setSenha(userModel.getSenha());
        return userDTO;
    }

}
