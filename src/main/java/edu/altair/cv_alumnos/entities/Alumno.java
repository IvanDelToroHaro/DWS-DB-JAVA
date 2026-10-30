package edu.altair.cv_alumnos.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cv_alumnos", schema = "cv_alumnos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alumnos_dni", columnNames = "dni")
})
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Column(name = "dni", nullable = false, length = 9, unique = true)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Column(name = "matricula", nullable = false, length = 100)
    private String matricula;
    
    @Column(name = "programa", nullable = false, length = 100)
    private String programa;

    @OneToMany(mappedBy = "alumno", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Matricula> matriculas = new ArrayList<>();

    // Constructores
    public Alumno() {}

    public Alumno(Long idAlumno, String dni, String nombre, String apellidos,
                  LocalDate fechaNacimiento, String telefono, String email, String matricula, String programa) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.matricula = matricula;
        this.programa = programa;
    }

    // Getters y Setters
    public Long getIdAlumno() { return idAlumno; }
    public void setIdAlumno(Long idAlumno) { this.idAlumno = idAlumno; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }

    public List<Matricula> getMatriculas() { return matriculas; }

    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
        matricula.setAlumno(this);
    }

}
