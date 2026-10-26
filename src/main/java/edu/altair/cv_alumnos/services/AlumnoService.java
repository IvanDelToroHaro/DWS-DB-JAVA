package edu.altair.cv_alumnos.services;

import edu.altair.cv_alumnos.dtos.AlumnoRequestDto;
import edu.altair.cv_alumnos.dtos.AlumnoResponseDto;
import java.util.List;

public interface AlumnoService {
    List<AlumnoResponseDto> obtenerTodos();
    AlumnoResponseDto obtenerPorId(Long id);
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);
    void eliminar(Long id);
}
