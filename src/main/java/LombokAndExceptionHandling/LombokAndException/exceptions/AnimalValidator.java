package LombokAndExceptionHandling.LombokAndException.exceptions;

import LombokAndExceptionHandling.LombokAndException.entity.Animal;
import LombokAndExceptionHandling.LombokAndException.entity.Kangaroo;
import LombokAndExceptionHandling.LombokAndException.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class AnimalValidator {

    public static void isIdValid(int id){
        if(id<=0){
            throw new AnimalException("Animal Id " + id + " is not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdNotExisting(Map animals, int id){
        if(!animals.containsKey(id)){
            throw new AnimalException("Animal with given Id " + id + " doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    public static void isIdExisting(Map animals, int id){
        if(animals.containsKey(id)){
            throw new AnimalException("Animal with given Id " + id + " already exists", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isAnimalValid(Animal animal) {
        if((animal.getName()==null)||animal.getName().isEmpty() ||animal.getWeight()<=0|| animal.getWeight()>100){
            throw new AnimalException("Animal credentials are not valid",HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKangarooValid(Kangaroo kangaroo){
        if(kangaroo.getHeight()<0.5||kangaroo.getHeight()>2.00){
            throw new AnimalException("Kangaroo credentials are not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKoalaValid(Koala koala){
        if(koala.getSleepHour()<18||koala.getSleepHour()>24){
            throw new AnimalException("Koala credentials are not valid", HttpStatus.BAD_REQUEST);
        }
    }


}
