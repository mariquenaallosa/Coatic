package modelo;

import javax.persistence.*;
import java.util.*;


@Entity
public class Alumno {
    @Id
    @SequenceGenerator(name="sec_alumno", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sec_alumno")
    private Long id;
    
    private String nombre;
    
    private String dni;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    
    // muchos alumnos se relacionan con muchos cursos
    @ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
    private Set<Curso> cursos;
    
    // muchas áreas se relacionan con el mismo Coatic
    @ManyToOne(cascade=CascadeType.REFRESH)
    private Coatic coatic;
    
    // constructor nulo
    public Alumno(){}
    
    // constructor con parametros
    
    public Alumno(String nombre, String dni, Date fechaNacimiento, Coatic coatic){
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.coatic = coatic;
    };
    
    
    // Getter y Setters

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

       
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Set<Curso> getCursos() {
        return this.cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Coatic getCoatic() {
        return this.coatic;
    }

    public void setCoatic(Coatic coatic) {
        this.coatic = coatic;
    }

        
}
