package edu.altair.cv_alumnos.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos", schema = "cv_alumnos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_departamentos_codigo", columnNames = "codigo")
})
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "departamento", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Profesor> profesores = new ArrayList<>();

    public Departamento() {}

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
        profesor.setDepartamento(this);
    }

    public Long getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Long idDepartamento) { this.idDepartamento = idDepartamento; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Profesor> getProfesores() { return profesores; }
}
