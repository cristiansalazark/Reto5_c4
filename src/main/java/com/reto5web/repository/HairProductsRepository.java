package com.reto5web.repository;
/**
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.reto5web.model.HairProducts;
import java.util.List;
import java.util.Optional;
import com.reto5web.repository.crud.HairProductsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HairProductsRepository {
    @Autowired
    private HairProductsCrudRepository repository;

    public List<HairProducts> getAll() {
        return repository.findAll();
    }

    public Optional<HairProducts> getHairProducts(String reference) {
        return repository.findById(reference);
    }
    
    public HairProducts create(HairProducts hairProducts) {
        return repository.save(hairProducts);
    }

    public void update(HairProducts hairProducts) {
        repository.save(hairProducts);
    }
    
    public void delete(HairProducts hairProducts) {
        repository.delete(hairProducts);
    }

    //Reto 5
    public List<HairProducts> productsByPrice(double precio){
        return repository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<HairProducts> findByDescriptionLike(String description){
        return repository.findByDescriptionLike(description);
    }
}
