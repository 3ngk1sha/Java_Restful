package vn.hoidanit.jobhunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.domain.dto.MetaDTO;
import vn.hoidanit.jobhunter.domain.dto.ResultPaginationDTO;
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
        return user.orElse(null);
    }
    public ResultPaginationDTO GetAllUsers(Specification<User> specification, Pageable pageable){
        Page<User> users = this.userRepository.findAll(specification,pageable);
        ResultPaginationDTO resultPaginationDTO = new ResultPaginationDTO();

        MetaDTO meta = new MetaDTO();
        meta.setPage(pageable.getPageNumber());
        meta.setPageSize(pageable.getPageSize());
        meta.setPages(users.getTotalPages());
        meta.setTotalPages(users.getTotalPages());

        resultPaginationDTO.setMeta(meta);
       resultPaginationDTO.setResult(users.getContent());

       return resultPaginationDTO;
    }

    public User UpdateUser(User newuser){
       Optional<User> user = this.userRepository.findById(newuser.getId());
       if(user.isPresent()){
           this.userRepository.save(newuser);
           return newuser;
       }else return null;
    }
}
