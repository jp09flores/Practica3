package com.Practica3.Service;

import com.Practica3.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
      public List<Arbol> getArboles(boolean estadoVida);
     
      
    public Arbol getArbol(Arbol arbol);
    
    public void save(Arbol arbol);
    
    //Se elimina un registro:
    public void delete(Arbol arbol);

}
