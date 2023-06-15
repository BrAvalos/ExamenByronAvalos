package ec.edu.espe.oficina.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.oficina.model.Sede;
import ec.edu.espe.oficina.service.SedeService;

@RestController
@RequestMapping("/api/v1/sedes")
public class SedeController {
    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }
    
    @GetMapping("/{code}")
    public ResponseEntity<List<Sede>> obtainByCodeInstitucion(@PathVariable(name = "code") Integer code) {
        List<Sede> sedes = this.sedeService.listByCodigoInstitucion(code);
            return ResponseEntity.ok(sedes);
    }

    @PostMapping
    public ResponseEntity<Sede> create(@RequestBody Sede sede) {
        try {
            Sede sedeRS = this.sedeService.create(sede);
            return ResponseEntity.ok(sedeRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

}
