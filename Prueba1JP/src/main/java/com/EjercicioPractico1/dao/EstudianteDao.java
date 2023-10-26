

package com.EjercicioPractico1.dao;

import com.EjercicioPractico1.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteDao extends JpaRepository<Estudiante, Long> {
    
    
    
}

