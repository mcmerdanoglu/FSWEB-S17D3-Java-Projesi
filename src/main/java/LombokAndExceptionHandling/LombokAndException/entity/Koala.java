package LombokAndExceptionHandling.LombokAndException.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Koala extends Animal{

    private int sleepHour;

}
