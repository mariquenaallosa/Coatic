package modelo;

import java.util.Set;
import javax.persistence.*;


@Entity
public class Area {
    @Id
    @SequenceGenerator(name="sec_area", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sec_area")
    private Long id;
    
    private String nombre;
    
    // muchas áreas se relacionan con el mismo Coatic
    @ManyToOne(cascade=CascadeType.REFRESH)
    private Coatic coatic;
    
    
     //El área conoce a todos los cursos
    @OneToMany(mappedBy="area")
    private Set<Curso> cursos;
    
    // constructor nulo
    public Area(){}
    
    // constructor con parametros
    
    public Area(String nombre, Coatic coatic){
        this.nombre = nombre;
        this.coatic = coatic;
    };

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
