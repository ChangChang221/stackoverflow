package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.response.UserResponse;
import com.stackoverflow.nhom24.repository.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class UserBusiness extends BaseBusiness {
//    private final UserRepository userRepository;
//
//    public List<UserResponse> getAllUser(){
//       List<User> users = userRepository.findAll();
//       List<UserResponse> response = mapper.mapAsList(users, UserResponse.class);
//       return response;
//    }
//
//    public UserResponse findById(Integer id){
//        User userDto = userRepository.findById(id).get();
//        UserResponse response = mapper.map(userDto, UserResponse.class);
//        return response;
//    }
//
//    public UserResponse insertUser(User user){
//        user.setCreatedOn(new Date());
//        userRepository.save(user);
//        UserResponse response = mapper.map(user, UserResponse.class);
//        return  response;
//    }
//
//    public UserResponse updateUser(User user) throws NotFoundException {
//        User currentUser = userRepository.findById(user.getId()).get();
//        if(currentUser == null){
//            throw new NotFoundException("Not found!");
//        }
//        userRepository.save(currentUser);
//        UserResponse response = mapper.map(currentUser, UserResponse.class);
//        return response;
//    }
//
//    public void deleteById(Integer id){
//        userRepository.deleteById(id);
//    }
}
