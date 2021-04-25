package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserBusiness extends BaseBusiness {
    private final UserRepository userRepository;

    public User createUser(User user){
        User userExisted = userRepository.findByUsername(user.getUsername());
        if(userExisted != null){
            //todo throw exception;
//            throw new Exception();
        }
        User newUser = userRepository.save(user);
        return newUser;
    }
}
