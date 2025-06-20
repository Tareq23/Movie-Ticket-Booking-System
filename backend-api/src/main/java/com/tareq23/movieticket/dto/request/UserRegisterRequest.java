package com.tareq23.movieticket.dto.request;

import com.tareq23.movieticket.validation.AtLeastOneOf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@AtLeastOneOf(fields = {"email", "phoneNumber"}, message = "Either email or phone number must be provided")
public record UserRegisterRequest(
        @Size(min = 2, max = 50, message = "Firstname should be greater than or equal 2 and less than or equal 50 characters")
        String firstName,
        @Size(min = 2, max = 50, message = "Lastname should be greater than or equal 2 and less than or equal 50 characters")
        String lastName,
        @Email
        String email,
        // customer validation will be add
        String phoneNumber
) {
}
