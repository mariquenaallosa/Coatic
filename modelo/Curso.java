package modelo;

import javax.persistence.*;
import java.util.*;


@Entity
public class Curso {
    @Id
    @SequenceGenerator(name="sec_curso", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sec_curso")
    private Long id;
    
    private String nombre;
    
    private int meses;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    
    private boolean presencial;
    
    
    // muchos cursos se relacionan con muchos alumnos  
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name="alumno_curso", 
            joinColumns = @JoinColumn(name ="curso_id"), 
            inverseJoinColumns = @JoinColumn(name="alumno_id")
    ) 
    private Set<Alumno> alumnos;
    
    // muchos cursos se relacionan con el mismo área
    @ManyToOne(cascade=CascadeType.REFRESH)
    private Area area;
    
    // muchos cursos se relacionan con el mismo Coatic
    @ManyToOne(cascade=CascadeType.REFRESH)
    private Coatic coatic;
    
    
    
    
    
    
    
    // constructor nulo
    public Curso(){}
    
    // constructor con parametros
    
    public Curso(String nombre, int meses, Date inicio, boolean presencial, Area area, Coatic coatic){
        this.nombre = nombre;
        this.meses = meses;
        this.inicio = inicio;
        this.presencial = presencial;
        this.area = area;
        this.coatic = coatic;
    };
    
    
    // Getter y Setters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public int getMeses() {
        return this.meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
     public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    
   public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Coatic getCoatic() {
        return coatic;
    }

    public void setCoatic(Coatic coatic) {
        this.coatic = coatic;
    }
    
    
    
}
