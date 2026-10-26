package edu.altair.cv_alumnos.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesores", schema = "cv_alumnos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_profesores_dni", columnNames = "dni")
})
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_departamento", nullable = false,
            foreignKey = @ForeignKey(name = "fk_profesores_departamento"))
    private Departamento departamento;

    @OneToMany(mappedBy = "profesor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Profesor() {}

    public Profesor(String dni, String nombre, Departamento departamento) {
        this.dni = dni;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public void addAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
        asignatura.setProfesor(this);
    }

    public Long getIdProfesor() { return idProfesor; }
    public void setIdProfesor(Long idProfesor) { this.idProfesor = idProfesor; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
    public List<Asignatura> getAsignaturas() { return asignaturas; }
}
