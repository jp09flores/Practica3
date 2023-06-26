
package com.Practica3.Controller;

import com.Practica3.Service.ArbolService;
import com.Practica3.domain.Arbol;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/arbol")
@Slf4j
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    @RequestMapping("/listado")
    public String page(Model model) {
        log.info("Consumo del Recurso /arbol/listado");
        List<Arbol> arboles = arbolService.getArboles(false);
        model.addAttribute("Lista_Arboles", arboles);
        model.addAttribute("Total_Categorias", arboles.size());
        return "/arbol/listado";
    }  
}
