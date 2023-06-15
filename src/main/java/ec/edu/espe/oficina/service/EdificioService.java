package ec.edu.espe.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.oficina.model.Edificio;
import ec.edu.espe.oficina.repository.EdificioRepository;
import jakarta.transaction.Transactional;

@Service
public class EdificioService {
    private final EdificioRepository edificioRepository;

    

      public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public List<Edificio> listBySedeOrderBySuperficie(String codigoSede){
        return this.edificioRepository.findByCodigoSedeOrderBySuperficieDesc(codigoSede);
    }

    @Transactional
    public Edificio update(Edificio edificio) {
        
        if (!this.edificioRepository.existsById(edificio.getPk())) {
            Optional<Edificio> edificioOpt = this.edificioRepository.findById(edificio.getPk());
            Edificio edificioTmp = edificioOpt.get();  //memoria del entity manager
            edificioTmp.setNombre(edificio.getNombre());
            edificioTmp.setPisos(edificio.getPisos());
            edificioTmp.setSuperficie(edificio.getSuperficie());
            this.edificioRepository.save(edificioTmp); //update
            return edificioTmp;
        } else {
            throw new RuntimeException("Edificio que desea modificar no esta registrado");
        }
    }
}
