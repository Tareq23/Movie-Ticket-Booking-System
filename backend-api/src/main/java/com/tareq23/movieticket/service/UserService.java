package com.tareq23.movieticket.service;

import com.tareq23.movieticket.dto.request.UserRegisterRequest;
import com.tareq23.movieticket.dto.response.UserResponse;
import com.tareq23.movieticket.mapper.UserMapper;
import com.tareq23.movieticket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse addNewUser(UserRegisterRequest registerRequest) {
        var user = userMapper.toUser(registerRequest);

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
