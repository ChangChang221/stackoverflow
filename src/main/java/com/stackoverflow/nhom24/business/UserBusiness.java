package com.stackoverflow.nhom24.business;

import com.stackoverflow.nhom24.business.base.BaseBusiness;
import com.stackoverflow.nhom24.entity.Tag;
import com.stackoverflow.nhom24.entity.User;
import com.stackoverflow.nhom24.model.request.LoginRequest;
import com.stackoverflow.nhom24.model.response.QuestionDetailResponse;
import com.stackoverflow.nhom24.model.response.QuestionResponse;
import com.stackoverflow.nhom24.model.response.TagResponse;
import com.stackoverflow.nhom24.model.response.UserResponse;
import com.stackoverflow.nhom24.repository.UserRepository;
import com.stackoverflow.nhom24.service.QuestionService;
import com.stackoverflow.nhom24.service.UserService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
@AllArgsConstructor
public class UserBusiness extends BaseBusiness {
    private final UserRepository userRepository;
    private final UserService userService;
    private final QuestionService questionService;


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

    public User getById(String id){
        User user = userRepository.findById(new ObjectId(id)).get();
        return user;
    }

    public void updateView(User user){
        user.setViews(user.getViews() + 1);
        userRepository.save(user);
    }

    public void updateUser(String id, User newUser){
        User currentUser = userRepository.findById(new ObjectId(id)).get();
        if(newUser.getPhoto() != null){
            currentUser.setPhoto(newUser.getPhoto());
        }
        currentUser.setName(newUser.getName());
        currentUser.setSocial(newUser.getSocial());
        currentUser.setLink(newUser.getLink());
        currentUser.setLocation(newUser.getLocation());
        currentUser.setWebsite(newUser.getWebsite());
        currentUser.setTitle(newUser.getTitle());
        userRepository.save(currentUser);
    }
    public List<UserResponse> getListUser(Integer page) {

        return userService.getAllUser(page);
    }

    public int getTotal() {
        return userRepository.findAll().size();
    }

    public List<UserResponse> getTagOfUser(List<UserResponse> users) {
        int sizeUsersList = users.size();
        for (int k = 0; k < sizeUsersList; k++) {
            List<QuestionResponse> questionResponseList = questionService.getByUserId(new ObjectId(users.get(k).getId()));

            Set<String> getTagsUserSet = new HashSet<>(); // khởi tao set để tránh trùng lặp tag
            int sizeQuestionResponse = questionResponseList.size();

            for (int i = 0; i < sizeQuestionResponse; i++) {
                //get list tag cho mỗi câu hỏi
                List<String> listTagUser = questionResponseList.get(i).getTags();
                int sizelistTagUser = listTagUser.size();

                //get các tag này vào set
                for (int  j = 0;  j < sizelistTagUser; j++) {
                    getTagsUserSet.add(listTagUser.get(j));
                }

                //chuyển các set thành list
                List<String> getTagUserList = new ArrayList<>();
                getTagUserList.addAll(getTagsUserSet);

                users.get(k).setTags(getTagUserList);

            }


        }


        return users;
    }
}
