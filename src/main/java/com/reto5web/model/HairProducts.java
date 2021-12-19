package com.reto5web.model;
/**
 * Esta clase define la entidad Hair Products
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hairproducts")
public class HairProducts {

    @Id
    private String reference;
    private String brand;
    private String category;
    private String name;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
}

