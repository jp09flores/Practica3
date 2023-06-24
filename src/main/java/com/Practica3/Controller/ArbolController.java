package com.Practica3.Controller;

import com.Practica3.Service.ArbolService;
import com.Practica3.domain.Arbol;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/arbol")
@Slf4j
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    @GetMapping("/listado")                             //Solo mediante peticiones GET
    public String page(Model model) {
        log.info("Consumo del Recurso /arbol/listado");
        List<Arbol> arboles = arbolService.getArboles("");
        model.addAttribute("Lista_Categorias", arboles);
        model.addAttribute("Total_Categorias", arboles.size());
        return "/arbol/listado";
    }
}
