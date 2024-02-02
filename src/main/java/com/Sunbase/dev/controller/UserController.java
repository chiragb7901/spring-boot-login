package com.Sunbase.dev.controller;

import com.Sunbase.dev.repository.User;
import com.Sunbase.dev.service.IUserService;
import com.Sunbase.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    IUserService iUserService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        return iUserService.getAll();
    }
    @PostMapping("/add")
    public User add(@RequestBody User u){
        return iUserService.add(u);
    }
    @GetMapping("/getById/{id}")
    public User getById(@PathVariable("id")long id){
        return iUserService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") long id){
        return iUserService.delete(id);
    }
    @PutMapping("/update/{id}")
    public User update(@RequestBody User u,@PathVariable("id") long id){
        return iUserService.update(u,id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        Optional<User> userOptional = userService.loginUser(username, password);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }


}
