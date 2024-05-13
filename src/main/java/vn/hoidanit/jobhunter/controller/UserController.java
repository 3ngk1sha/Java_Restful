package vn.hoidanit.jobhunter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //@GetMapping("/user/create")
    @PostMapping("/user/create")
    public User createNewUser( @RequestBody User user ) {
//        User newUser = new User();
//        newUser.setEmail("dungbn765@gmail.com");
//        newUser.setName("Dungbn765");
//        newUser.setPassword("123");
       User newUser = this.userService.SaveUser(user);
        return newUser;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser( @PathVariable long id) {
        this.userService.DeleteUserById(id);
    }

    @GetMapping("/user/{id}")
    public User getUserbyId( @PathVariable("id") long id ) {
       return this.userService.GetUserById(id);

    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return this.userService.GetAllUsers();

    }

    @PutMapping("/user")
    public User updateUser( @RequestBody User user ) {

        return this.userService.UpdateUser(user);
    }
}
