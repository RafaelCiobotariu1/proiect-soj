package org.endava.tmd.sojbookrentalproject.controlers;


import org.endava.tmd.sojbookrentalproject.models.User;
import org.endava.tmd.sojbookrentalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public User get(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User create(@RequestBody final User user)
        {
        return userRepository.saveAndFlush(user);
    }

    @PutMapping
    public User update(@RequestBody final User user){
        return userRepository.saveAndFlush(user);
    }


    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id){
        User user =  userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
