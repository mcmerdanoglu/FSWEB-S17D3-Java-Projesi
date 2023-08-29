package LombokAndExceptionHandling.LombokAndException.controller;

import LombokAndExceptionHandling.LombokAndException.entity.Gender;
import LombokAndExceptionHandling.LombokAndException.entity.Kangaroo;
import LombokAndExceptionHandling.LombokAndException.exceptions.AnimalValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
        // Initial olarak bir tane kangaroo instance yaratmak istediğimiz için Kangaroo constructorunu class içinde ezdik
        // ve variableları buraya yazarak 1 adet otomatik oluşacak kangaroo nesnesi hazırladık
        kangaroos.put(1, new Kangaroo(1,"Lena", 40, Gender.FEMALE, 1.5,false));
    }

    @GetMapping("/")
    public List<Kangaroo> getAllKangaroos() {
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable int id) {
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExisting(kangaroos, id);

        return kangaroos.get(id);
    }

    @PostMapping("/")
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo) {
        AnimalValidator.isIdValid(kangaroo.getId());
        AnimalValidator.isIdExisting(kangaroos, kangaroo.getId());
        AnimalValidator.isAnimalValid(kangaroo);
        AnimalValidator.isKangarooValid(kangaroo);
        //TODO Check kangaroo properties(exp. Height...)

        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo kangaroo) {
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExisting(kangaroos, id);
        AnimalValidator.isAnimalValid(kangaroo);
        AnimalValidator.isKangarooValid(kangaroo);
        //TODO Check kangaroo properties(exp. Height...)

        kangaroo.setId(id);//JSON içerisinde id gönderilmezse, Kangaroonun idsini "0" kaydetmemek için.
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable int id){
        AnimalValidator.isIdValid(id);
        AnimalValidator.isIdNotExisting(kangaroos, id);

        Kangaroo kangaroo = kangaroos.get(id);
        kangaroos.remove(id);
        return kangaroo;
    }

}
