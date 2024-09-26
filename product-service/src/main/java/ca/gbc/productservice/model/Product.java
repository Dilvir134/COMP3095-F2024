package ca.gbc.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value="product") // Creates this table for us in mongodb
@Data // getters and setts and all boilerplate code
@AllArgsConstructor // Constructor that accepts all arguments
@NoArgsConstructor // Constructor that accepts no arguments
@Builder // Cleaner way to instantiate objects of this class
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
