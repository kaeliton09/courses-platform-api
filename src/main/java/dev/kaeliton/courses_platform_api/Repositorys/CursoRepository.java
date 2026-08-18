package dev.kaeliton.courses_platform_api.Repositorys;

import dev.kaeliton.courses_platform_api.Models.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {
}
