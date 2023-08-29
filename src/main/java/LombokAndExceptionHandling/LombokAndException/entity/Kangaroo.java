package LombokAndExceptionHandling.LombokAndException.entity;

import lombok.Data;

@Data
public class Kangaroo extends Animal{

    private double height;

    private boolean isAggressive;

    // Initial olarak kangaroo instancei oluşturmak istediğimiz için Anamaldaki methodu ezdik kendi istediğimiz constructoru yazdık.
    // Çünkü Controllerdeki Post Constructorda örnek bir kangaroo nesnesi göndereceğiz, o yüzden bu variableların yazılması gerek.
    public Kangaroo(int id, String name, double weight, Gender gender, double height, boolean isAggressive) {
        super(id, name, weight, gender);
        this.height = height;
        this.isAggressive = isAggressive;
    }
}
