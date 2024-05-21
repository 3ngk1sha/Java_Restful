package vn.hoidanit.jobhunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User SaveUser(User user){
       return this.userRepository.save(user);
    }
    public User getUserByEmail(String username){
        return this.userRepository.findByEmail(username);
    }
    public void DeleteUserById(long id){
        this.userRepository.deleteById(id);
    }

    public User GetUserById(long id){
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else return null;
    }
    public List<User> GetAllUsers(){
        return this.userRepository.findAll();
    }

    public User UpdateUser(User newuser){
       Optional<User> user = this.userRepository.findById(newuser.getId());
       if(user.isPresent()){
           this.userRepository.save(newuser);
           return newuser;
       }else return null;
    }
}
