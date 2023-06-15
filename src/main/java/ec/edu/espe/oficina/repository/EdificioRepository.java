package ec.edu.espe.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.oficina.model.Edificio;
import ec.edu.espe.oficina.model.EdificioPK;

public interface EdificioRepository  extends JpaRepository<Edificio, EdificioPK>{
        List<Edificio> findByPkCodigoSedeOrderBySuperficieDesc(String sedePattern);

}
