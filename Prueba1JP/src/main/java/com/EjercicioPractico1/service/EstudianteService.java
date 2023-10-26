

package com.EjercicioPractico1.service;

import com.EjercicioPractico1.domain.Estudiante;
import java.util.List;

public interface EstudianteService {

    /**
     *
     * @param id
     * @return
     */
    public abstract List <Estudiante> getEstudiantes(Long id);

    

    public Estudiante getEstudiante(Estudiante estudiante);
    

    public void save(Estudiante estudiante);
    

    public void delete(Estudiante estudiante);
}
// Fin de la clase
    

