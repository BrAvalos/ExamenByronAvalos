package ec.edu.espe.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.oficina.model.Sede;
import ec.edu.espe.oficina.repository.SedeRepository;
import jakarta.transaction.Transactional;

@Service
public class SedeService {
    private final SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public Optional<Sede> obtainByCode(String code) {
        return this.sedeRepository.findById(code);
    }

   
    public List<Sede> listByCodigoInstitucion(Integer codigoInstitucion) {
        return this.sedeRepository.findByCodigoInstitucionLikeOrderByCodigoInstitucion(codigoInstitucion);
    }

    @Transactional
    public Sede create(Sede sede) {
        Sede sedeTmp = this.sedeRepository.findByNombreAndDireccion(sede.getNombre(), sede.getDireccion());
        Integer numPrincipal = this.sedeRepository.findByEsPrincipal(true).size();
        if (sedeTmp == null) {
            if(numPrincipal<1){
                return this.sedeRepository.save(sede);
            }
            else{
                throw new RuntimeException("Ya existe una sede principal");
            }
            
        } else {
            throw new RuntimeException("Sede ya existe");
        }
    }


}
