package edu.altair.cv_alumnos.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas", schema = "cv_alumnos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_matriculas_alumno_asignatura", columnNames = {"id_alumno", "id_asignatura"})
})
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", nullable = false,
            foreignKey = @ForeignKey(name = "fk_matriculas_alumno"))
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_asignatura", nullable = false,
            foreignKey = @ForeignKey(name = "fk_matriculas_asignatura"))
    private Asignatura asignatura;

    @Column(name = "fecha_matriculacion", nullable = false)
    private LocalDate fechaMatriculacion;

    @Column(name = "nota_final", precision = 5, scale = 2)
    private BigDecimal notaFinal;

    public Matricula() {}

    public Matricula(Alumno alumno, Asignatura asignatura, LocalDate fechaMatriculacion, BigDecimal notaFinal) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.fechaMatriculacion = fechaMatriculacion;
        this.notaFinal = notaFinal;
    }

    public Long getIdMatricula() { return idMatricula; }
    public void setIdMatricula(Long idMatricula) { this.idMatricula = idMatricula; }
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }
    public LocalDate getFechaMatriculacion() { return fechaMatriculacion; }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) { this.fechaMatriculacion = fechaMatriculacion; }
    public BigDecimal getNotaFinal() { return notaFinal; }
    public void setNotaFinal(BigDecimal notaFinal) { this.notaFinal = notaFinal; }
}
