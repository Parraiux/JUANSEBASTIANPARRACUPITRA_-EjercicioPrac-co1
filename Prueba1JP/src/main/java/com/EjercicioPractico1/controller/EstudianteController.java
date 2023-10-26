

package com.EjercicioPractico1.controller;

import com.EjercicioPractico1.domain.Estudiante;
import com.EjercicioPractico1.service.EstudianteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes(Long.MIN_VALUE);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("totalEstudiantes", estudiantes.size());
        return "/estudiantes/istado";
    }

    
     @GetMapping("/nuevo")
    public String estudianteNuevo(Estudiante estudiante) {
        return "/estudiantes/modifica";
    }

     @GetMapping("/eliminar/{id}")
    public String estudianteEliminar(Estudiante estudiante) {
        estudianteService.delete(estudiante);
        return "redirect:/estudiantes/listado";
    }
    @GetMapping("/modificar/{id}")
    public String estudianteModificar(Estudiante estudiante, Model model) {
        estudiante = estudianteService.getEstudiante(estudiante);
        model.addAttribute("categoria", estudiante);
        return "/estudiantes/modifica";
    }
    
}