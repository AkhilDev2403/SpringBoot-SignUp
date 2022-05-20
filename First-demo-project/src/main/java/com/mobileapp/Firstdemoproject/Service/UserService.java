package com.mobileapp.Firstdemoproject.Service;

import com.mobileapp.Firstdemoproject.Dto.UserDto;
import com.mobileapp.Firstdemoproject.model.User.RegistrationRequest;
import com.mobileapp.Firstdemoproject.model.common.AbstractResponse;
import com.mobileapp.Firstdemoproject.model.request.UserRequest;

public interface UserService {
    UserDto createUser(UserDto user);

    String createSignUp(RegistrationRequest registrationRequest);

    AbstractResponse<String> registerNewUser(UserRequest userRequest);

    Boolean emailAlreadyExist(String email);

    Boolean userNameAlreadyExist(String userName);
}
