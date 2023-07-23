package sistema;

import modelo.Area;
import modelo.Coatic;


public class Inicio {
    
    public static void main(String[] args) {
        
        Coatic c = (Coatic)  Coatic.getPersistencia().buscar(Coatic.class, 1L);
        
        
        if(c == null){
            c = new Coatic(1L, "Red CoaTIC");
        }
        
        Area a1 = new Area("Programación", c);
        Area a2 = new Area("Marketing", c);
        
        Coatic.getPersistencia().insertar(a1);
        Coatic.getPersistencia().insertar(a2);
    }
    
}
