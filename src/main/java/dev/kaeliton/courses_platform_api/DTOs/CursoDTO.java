package dev.kaeliton.courses_platform_api.DTOs;

import dev.kaeliton.courses_platform_api.Models.NivelCurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private NivelCurso nivel;
    private int totalAulas;
    private int totalHoras;

}
