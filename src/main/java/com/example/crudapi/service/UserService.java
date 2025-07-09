package com.example.crudapi.service;


import com.example.crudapi.dto.UserRequest;
import com.example.crudapi.dto.UserResponse;
import java.util.List;
public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUserById(Long id);
    List<UserResponse> findAll();
    UserResponse updateUser(Long id,UserRequest userRequest);
    void deleteUser(Long id);
}
