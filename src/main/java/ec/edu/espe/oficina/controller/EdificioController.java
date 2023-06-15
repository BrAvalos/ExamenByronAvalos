package ec.edu.espe.oficina.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.oficina.model.Edificio;
import ec.edu.espe.oficina.service.EdificioService;


@RestController
@RequestMapping("/api/v1/edificios")
public class EdificioController {

    private final EdificioService edificioService;

    


    public EdificioController(EdificioService edificioService) {
        this.edificioService = edificioService;
    }




    @GetMapping("/{code}")
    public ResponseEntity<List<Edificio>> obtainBySedeOrderBySuperficie(@PathVariable(name = "code") String code) {
        List<Edificio> edificios = this.edificioService.listBySedeOrderBySuperficie(code);
            return ResponseEntity.ok(edificios);
    }


    @PutMapping
    public ResponseEntity<Edificio> update(@RequestBody Edificio edificio) {
        try {
            Edificio edificioRS = this.edificioService.update(edificio);
            return ResponseEntity.ok(edificioRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
}
