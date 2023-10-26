

package com.EjercicioPractico1.service.impl;
import com.EjercicioPractico1.dao.EstudianteDao;
import com.EjercicioPractico1.domain.Estudiante;
import com.EjercicioPractico1.service.EstudianteService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService{
    @Autowired
    private EstudianteDao estudianteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getEstudiantes(Long id) {
        var lista = estudianteDao.findAll();
        lista.removeIf(e -> !Objects.equals(e.getId(), id));
        return lista;
    }


    @Override
    @Transactional(readOnly = true)
    public Estudiante getEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }


}
