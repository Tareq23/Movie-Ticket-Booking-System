package com.tareq23.movieticket.mapper;

import com.tareq23.movieticket.dto.request.UserRegisterRequest;
import com.tareq23.movieticket.dto.response.UserResponse;
import com.tareq23.movieticket.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {


    public User toUser(UserRegisterRequest request) {
        return User.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .contactNumber(request.phoneNumber())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getFirstName()+" "+user.getLastName(), user.getEmail(), user.getContactNumber());
    }
}
