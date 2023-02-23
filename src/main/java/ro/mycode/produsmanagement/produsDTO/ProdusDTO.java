package ro.mycode.produsmanagement.produsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdusDTO {

    @NotNull

    private Long id;
    private double price;
    private int stock;
    private String description;
    private double weight;
}
