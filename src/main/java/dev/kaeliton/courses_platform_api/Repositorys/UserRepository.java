package dev.kaeliton.courses_platform_api.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.kaeliton.courses_platform_api.Models.UserModel;

public interface  UserRepository extends JpaRepository<UserModel, Long> {

}
