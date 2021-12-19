package com.reto5web.service;
/**
 * @since 19-12-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.reto5web.model.User;
import com.reto5web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    /**
     * se instancia UserRepository como userRepository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return lista de usuarios
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     *
     * @param id
     * @return usuario por id
     */
    public Optional<User> getUser(int id) {
        
        return userRepository.getUser(id);
    }

    /**
     *
     * @param user
     * @return id maximo
     */
    public User create(User user) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();
        
        //si el id del Usuario que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        /**
         * optional para comprobar si el usuario existe
         * guarda usuario y si no, devuelve los datos ingresados
         */
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
        
    }

    /**
     *
     * @param user
     * @return actualiza el usuario o retorna los datos ingresados
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     *
     * @param userId
     * @return booleano y si es True elimina usuario por id
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     *
     * @param email
     * @return booleano de validación de existencia de usuario
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     *
     * @param email
     * @param password
     * @return usuario autenticado
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }


    public List<User> listBirthtDayMonth(String month){
        return userRepository.listBirthtDayMonth(month);
    }
}
