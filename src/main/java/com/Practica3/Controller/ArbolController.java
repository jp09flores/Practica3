package com.Practica3.Controller;

import com.Practica3.Service.ArbolService;
import com.Practica3.domain.Arbol;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/nuevo")
    public String ArbolNuevo(Arbol arbol) {
        return "/arbol/editar";
    }

  

//    @Autowired
//    @PostMapping("/guardar")
//    public String arbolGuardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile) {
//        if (!imagenFile.isEmpty()) {
//            arbolService.save(arbol);
//            arbol.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile,
//                            "arbol",
//                            arbol.getIdArbol()));
//        }
//        arbolService.save(arbol);
//        return "redirect:/arbol/listado";
//    }

    @GetMapping("/eliminar/{idArbol}")
    public String ArbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/editar/{idArbol}")
    public String arboleditar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/editar";
    }

}
