package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.service.UserService;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() { }
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username){
        return userService.findUserByUsername(username).get();
    }
    @GetMapping("/info/{email}")
    public User getUserDetails(@PathVariable String email){
        //String e = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findAppUser(email).get();
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateAppUser(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") int userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.delete(id);
    }

    @GetMapping("/nbUsers")
    public long getNbUsers(){
        return userService.getNbUsers();
    }

    @GetMapping("/countByTypeSang/{typeSang}")
    public long countByTypeSang(@PathVariable("typeSang") String typeSang){
        return userService.countByTypeSang(typeSang);
    }

    @GetMapping("/byRole/{role}")
        public List<User> findByRole(@PathVariable ("role") RoleName role){
        return userService.findAllByRolesByRolename(role);
        }
}