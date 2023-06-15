package ec.edu.espe.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.oficina.model.Sede;

public interface SedeRepository extends JpaRepository<Sede, String>  {
    List<Sede> findByCodigoInstitucionLikeOrderByCodigoInstitucion(Integer institucionPattern);
    Sede findByNombreAndDireccion(String nombre, String direccion);
    List<Sede>  findByEsPrincipal(boolean atributo);
    
}
