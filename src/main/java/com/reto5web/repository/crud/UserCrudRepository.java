package com.reto5web.repository.crud;
/**
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.reto5web.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
    
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();

    //Reto 5: Listado de cumpleaños del mes
    List<User> findByMonthBirthtDay(String month);
}
