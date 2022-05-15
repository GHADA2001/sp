package com.grokonez.jwtauthentication.service;

import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException ;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAllByRolesByRolename(RoleName role){
        return userRepo.findAllByRolesName(role);
    }

    public Optional<User> findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }
    public Optional<User> findAppUser(String email){
        return userRepo.findByEmail(email);
    }

    public ResponseEntity<User> updateAppUser(User user) {

        User existingAppUser = userRepo.findByEmail(user.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("Could not find User with email = " + user.getEmail())
        );

        if (user.getUsername()!=null) existingAppUser.setUsername(user.getUsername());
        if (user.getEmail()!=null) existingAppUser.setEmail(user.getEmail());
        if (user.getPhone()!=null) existingAppUser.setPhone(user.getPhone());
        if (user.getRegion()!=null) existingAppUser.setRegion(user.getRegion());
        if (user.getImage()!=null) existingAppUser.setImage(user.getImage());

        if (user.getGenre()!=null) existingAppUser.setGenre(user.getGenre());
        if (user.getAge()!=0) existingAppUser.setAge(user.getAge());
        if (user.getNbDemandeSang()!=0) existingAppUser.setNbDemandeSang(user.getNbDemandeSang());
        if (user.getNbDonSang()!=0) existingAppUser.setNbDonSang(user.getNbDonSang());
        if (user.getNbPoints()!=0) existingAppUser.setNbPoints(user.getNbPoints());
        if (user.getPoids()!=null) existingAppUser.setPoids(user.getPoids());
        if (user.getTaille()!=null) existingAppUser.setTaille(user.getTaille());
        if (user.getTypeSang()!=null) existingAppUser.setTypeSang(user.getTypeSang());

        userRepo.save(existingAppUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(long userId) {
        return userRepo.findById(userId);
    }

    public void delete(long id) {
        userRepo.deleteById(id);
    }

    public long getNbUsers() {
        return userRepo.count();
    }

    public long countByTypeSang(String typeSang) {
        return userRepo.countByTypeSang(typeSang);
    }

    public  int enableAppUser(String email){
            return userRepo.enableAppUser(email);
    }

}