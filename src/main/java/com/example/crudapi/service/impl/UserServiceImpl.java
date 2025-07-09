package com.example.crudapi.service.impl;

import com.example.crudapi.dto.UserRequest;
import com.example.crudapi.dto.UserResponse;
import com.example.crudapi.exception.UserNotFoundException;
import com.example.crudapi.model.User;
import com.example.crudapi.service.UserService;
import com.example.crudapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest){
        User user = new User(null, userRequest.getName(), userRequest.getEmail());
        return toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return toResponse(user);
    }

    @Override
    public List<UserResponse> findAll(){
        return userRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Long id,UserRequest userRequest){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        return toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    private UserResponse toResponse(User user){
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}