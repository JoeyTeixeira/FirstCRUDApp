package com.teixeira.app.Rest.Controller;
import com.teixeira.app.Rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.teixeira.app.Rest.Models.User;

/*
 * API Controller class the esentially does all the work,
 * we have one of each CRUD funtionality listed below, denoted by
 * annotaions above the method
 */
@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome!";
    }
    
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
     }
    
     @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }
    
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        //Find the user we want to update
        User updatedUser = userRepo.findById(id).get();

        //Update all the variables of that user with the Body that was called with this method
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Deleted user with ID: " + id;
    }
}
