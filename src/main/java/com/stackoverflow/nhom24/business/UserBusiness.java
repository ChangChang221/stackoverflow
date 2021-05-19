package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.request.LoginRequest;
import com.stackoverflow.nhom24.model.response.UserResponse;
import com.stackoverflow.nhom24.repository.UserRepository;
import com.stackoverflow.nhom24.service.UserService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserBusiness extends BaseBusiness {
    private final UserRepository userRepository;
    private final UserService userService;

    public User login(LoginRequest model) throws NotFoundException {
        User user = userRepository.findByUsername(model.getUsername());
        if(user == null){
            throw new NotFoundException("sign failed");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!bCryptPasswordEncoder.encode(model.getPassword()).equals(user.getPassword())){
            throw new NotFoundException("sign failed");
        }
        return user;
    }

    public User createUser(User user){
        User userExisted = userRepository.findByUsername(user.getUsername());
        if(userExisted != null){
            //todo throw exception;
//            throw new Exception();
        }
        User newUser = userRepository.save(user);
        return newUser;
    }

    public UserResponse getUserById(String id){
        UserResponse user = userService.getById(id);
        return user;
    }
}
