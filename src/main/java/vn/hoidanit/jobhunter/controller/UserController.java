package vn.hoidanit.jobhunter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.service.error.IDInvalidException;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    //@GetMapping("/user/create")
    @PostMapping("/users/create")
    public ResponseEntity<User> createNewUser(@RequestBody User user ) {
//        User newUser = new User();
//        newUser.setEmail("dungbn765@gmail.com");
//        newUser.setName("Dungbn765");
//        newUser.setPassword("123");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       User newUser = this.userService.SaveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }



    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser( @PathVariable long id) throws Exception {
        if(id >=1000){
            throw new IDInvalidException("Id must be greater than 1000");
        }
        this.userService.DeleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserbyId( @PathVariable("id") long id ) {
       User user = this.userService.GetUserById(id);
       //return ResponseEntity.ok("user");
       return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.GetAllUsers();

    }

    @PutMapping("/users")
    public User updateUser( @RequestBody User user ) {

        return this.userService.UpdateUser(user);
    }
}
