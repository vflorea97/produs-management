package ro.mycode.produsmanagement.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name = "Produs")
@Table(name = "produs")
@Getter
@Setter
public class Produs implements Comparable<Produs> {

    @Id
    @SequenceGenerator( name = "produs_sequence", sequenceName = "produs_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produs_sequence")


    private Long id;

    @Column(name = "sku", nullable = false)
    @Size(min = 7, max = 7, message = "Sku-ul trebuie sa contina fix 7 caractere")
    private int sku;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "weight", nullable = false)
    @Max(value = 20, message = "Greutatea maxima a unui produs este de 30 kg")
    private double weight;

    @Column(name = "descriptions", nullable = false)
    @Max(value = 100, message = "Descrierea produsului trebuie sa fie de maxim 100 de caractere")
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @Column(name = "stock", nullable = false)
    @Min(value = 1, message = "Stock-ul trebuie sa contina obligatoriu cel putin o bucata")
    private int stock;

    @Override
    public int compareTo(Produs produs) {
        if (this.sku > produs.sku){
            return 1;
        }
        if (this.sku < produs.sku){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Produs p = (Produs) o;
        return this.sku == p.sku;
    }
}
