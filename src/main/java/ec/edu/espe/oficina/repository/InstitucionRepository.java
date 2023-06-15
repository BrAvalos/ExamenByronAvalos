package ec.edu.espe.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.oficina.model.Institucion;

public interface InstitucionRepository extends JpaRepository<Institucion, Integer>{
    
}
