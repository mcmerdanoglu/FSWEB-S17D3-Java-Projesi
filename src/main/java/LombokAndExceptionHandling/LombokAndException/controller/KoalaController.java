package LombokAndExceptionHandling.LombokAndException.controller;

import LombokAndExceptionHandling.LombokAndException.entity.Kangaroo;
import LombokAndExceptionHandling.LombokAndException.entity.Koala;
import LombokAndExceptionHandling.LombokAndException.exceptions.AnimalValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @GetMapping("/")
    public List<Koala> getAllKoalas() {
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable int id) {
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExisting(koalas, id);

        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala addKoala(@RequestBody Koala koala) {
        AnimalValidator.isIdValid(koala.getId());
        AnimalValidator.isIdExisting(koalas, koala.getId());
        AnimalValidator.isAnimalValid(koala);
        AnimalValidator.isKoalaValid(koala);
        //TODO Check kangaroo properties(exp. Height...)

        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable int id, @RequestBody Koala koala) {
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExisting(koalas, id);
        AnimalValidator.isAnimalValid(koala);
        AnimalValidator.isKoalaValid(koala);
        //TODO Check kangaroo properties(exp. Height...)

        koala.setId(id);//JSON içerisinde id gönderilmezse, Kangaroonun idsini "0" kaydetmemek için.
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable int id){
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExisting(koalas,id);

        Koala koala = koalas.get(id);
        koalas.remove(id);
        return koala;
    }
}
