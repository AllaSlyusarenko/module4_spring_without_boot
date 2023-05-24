package ru.practicum.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.user.UserState;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;

    private String lastName;

    private String email;

    private String registrationDate;

    private UserState state;
}
