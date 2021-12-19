package com.reto5web.repository.crud;
/**
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */

import com.reto5web.model.HairProducts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface HairProductsCrudRepository extends MongoRepository<HairProducts, String> {
    //Reto 5
    public List<HairProducts> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<HairProducts> findByDescriptionLike(String description);
}

