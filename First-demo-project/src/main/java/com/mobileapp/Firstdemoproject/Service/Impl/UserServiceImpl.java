package com.mobileapp.Firstdemoproject.Service.Impl;

import com.mobileapp.Firstdemoproject.Dto.UserDto;
import com.mobileapp.Firstdemoproject.Entity.UserEntity;
import com.mobileapp.Firstdemoproject.Repository.UserRepository;
import com.mobileapp.Firstdemoproject.Service.UserService;
import com.mobileapp.Firstdemoproject.model.User.RegistrationRequest;
import com.mobileapp.Firstdemoproject.model.common.AbstractResponse;
import com.mobileapp.Firstdemoproject.model.request.UserRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    public static Logger logger = LogManager.getLogger(UserService.class);

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUser = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser, returnValue);
        return returnValue;
    }

    public String createSignUp(RegistrationRequest registrationRequest){
        return null;
    }
    @Override
    public AbstractResponse<String> registerNewUser(UserRequest userRequest){
        AbstractResponse<String> newUserRequest = new AbstractResponse<>();
        try {
            Boolean isEmailAlreadyExist = userService.emailAlreadyExist(userRequest.getEmail());
            if (isEmailAlreadyExist){
                newUserRequest.setSuccess(false);
                logger.info("User with given "+ userRequest.getEmail() +" email id is already existing");
                newUserRequest.setMessage("User already registered");
                return newUserRequest;
            }
            Boolean isUserNameAlreadyExist = userService.userNameAlreadyExist(userRequest.getUserName());
            if(isUserNameAlreadyExist){
                newUserRequest.setSuccess(false);
                logger.info("User with given "+ userRequest.getUserName() +" userName is already existing");
                newUserRequest.setMessage("Username already exist");
            }
        }
        catch (Exception e){
            logger.error("Unable to process the operation..! Please try again", e);
        }

        return newUserRequest;
    }

    public Boolean emailAlreadyExist(String email){
        try {
            Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
            if (!optionalUser.isPresent()){
                return false;
            }
            else {
                logger.info("The email id entered is already existed");
                return true;
            }
        }
        catch (Exception e){
            logger.error("Unable to process the operation... Please try again", e);
            return true;
        }
    }

   public Boolean userNameAlreadyExist(String userName){
        try {
            Optional<UserEntity> optionalUser = userRepository.findByUserName(userName);
            if (!optionalUser.isPresent()){
                return false;
            }
            else {
                logger.info("The username entered is already existed");
                return true;
            }
        }
        catch (Exception e){
            logger.error("Unable to process the operation... Please try again", e);
            return true;
        }
   }



}
