package com.reto5web.repository;
/**
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.reto5web.model.User;
import com.reto5web.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;



@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    public void update(User user) {
        userCrudRepository.save(user);
    }
    
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    public List<User> listBirthtDayMonth(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
