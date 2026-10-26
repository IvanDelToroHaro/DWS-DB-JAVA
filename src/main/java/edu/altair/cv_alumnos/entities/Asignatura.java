package edu.altair.cv_alumnos.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas", schema = "cv_alumnos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_asignaturas_codigo", columnNames = "codigo")
})
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long idAsignatura;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_profesor", nullable = false,
            foreignKey = @ForeignKey(name = "fk_asignaturas_profesor"))
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Matricula> matriculas = new ArrayList<>();

    public Asignatura() {}

    public Asignatura(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
        matricula.setAsignatura(this);
    }

    @Transient
    public boolean isActiva() {
        return !matriculas.isEmpty();
    }

    public Long getIdAsignatura() { return idAsignatura; }
    public void setIdAsignatura(Long idAsignatura) { this.idAsignatura = idAsignatura; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public List<Matricula> getMatriculas() { return matriculas; }
}
