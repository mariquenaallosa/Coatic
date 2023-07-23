package modelo;

import java.util.*;
import javax.persistence.*;
import persistencia.Persistencia;

@Entity
public class Coatic {

    @Id
    private Long id;

    private String nombre;

    private static Persistencia persistencia;

    //Coatic conoce a todas las áreas
    @OneToMany(mappedBy = "coatic")
    private Set<Alumno> alummnos;

    //Coatic conoce a todas las áreas
    @OneToMany(mappedBy = "coatic")
    private Set<Area> areas;

    //Coatic conoce a todos los cursos
    @OneToMany(mappedBy = "coatic")
    private Set<Curso> cursos;

    // constructor nulo (necesario)
    public Coatic() {
    }

    // constructor con parámetros
    public Coatic(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;

        /*
        * Cuando se contruye el Coatic
        * se guarda en la BD a si mismo
         */
        Coatic.persistencia.insertar(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Persistencia getPersistencia() {
        return persistencia;
    }

    static {
        persistencia = new Persistencia();
    }

    public Set<Alumno> getAlummnos() {
        return alummnos;
    }

    public void setAlummnos(Set<Alumno> alummnos) {
        this.alummnos = alummnos;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    //Coatic gestiona las areas
    public void crearArea(String nombre) {
        Area area = new Area(nombre, this);
        this.areas.add(area);
        Coatic.getPersistencia().insertar(area);
    }

    public void modificarArea(Area area, String nombre) {
        if (area != null) {
            area.setNombre(nombre);
            Coatic.getPersistencia().modificar(area);
        }
    }

    public void eliminarArea(Area area) {
        if (area != null) {
            Coatic.getPersistencia().eliminar(area);
        }
    }

}
