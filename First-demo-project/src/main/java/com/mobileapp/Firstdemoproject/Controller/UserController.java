package com.mobileapp.Firstdemoproject.Controller;

import com.mobileapp.Firstdemoproject.Dto.UserDto;
import com.mobileapp.Firstdemoproject.Service.UserService;
import com.mobileapp.Firstdemoproject.model.User.RegistrationRequest;
import com.mobileapp.Firstdemoproject.model.common.AbstractResponse;
import com.mobileapp.Firstdemoproject.model.request.UserDetailsRequestModel;
import com.mobileapp.Firstdemoproject.model.request.UserRequest;
import com.mobileapp.Firstdemoproject.model.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("users")                //http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(){
        return "get method was called.";
    }


    @PostMapping("/signup")
    public AbstractResponse<String> signUp(@RequestBody RegistrationRequest registrationRequest, HttpServletResponse response){
        AbstractResponse<String> signUpResponse = new AbstractResponse<>();
        String id = userService.createSignUp(registrationRequest);
        return signUpResponse;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserResponse returnValue = new UserResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @PostMapping
    public  AbstractResponse<String> registerNewUser(@RequestBody UserRequest userRequest){
        return userService.registerNewUser(userRequest);
    }

    @PutMapping
    public String editUser(){
        return "put method is called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete method is called.";
    }
}
