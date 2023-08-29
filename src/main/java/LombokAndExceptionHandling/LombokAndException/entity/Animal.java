package LombokAndExceptionHandling.LombokAndException.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok bizi boiler plate kodlardan kurtarır
@Data // Getter-Setterlar ile toString - hashCode - equals methodları için kısayol olarak konulur.
@AllArgsConstructor // Tüm propertyleri içeren constructor için
@NoArgsConstructor // İçi boş olan constructor için
@Builder //Object oluşturma kanusunda yardımcı olur. Ayrıca nokta (.) ile erişebilme özelliği de katar.
public class Animal {
    private int id;
    private String name;
    private double weight;
    private Gender gender;
}
