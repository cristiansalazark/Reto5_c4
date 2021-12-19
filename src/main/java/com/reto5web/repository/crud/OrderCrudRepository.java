package com.reto5web.repository.crud;
/**
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.reto5web.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    //Retorna las ordenes de pedido que coincida con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
