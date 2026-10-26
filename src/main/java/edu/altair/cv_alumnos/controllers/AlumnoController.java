package edu.altair.cv_alumnos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.cv_alumnos.dtos.AlumnoResponseDto;
import edu.altair.cv_alumnos.services.AlumnoService;


@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // 1. READ ALL - GET /api/alumnos
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/alumnos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id)); // HTTP 200 OK
    }
}
