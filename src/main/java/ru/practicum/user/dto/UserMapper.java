package ru.practicum.user.dto;

import ru.practicum.user.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UserMapper {
    //Поле registrationDate в UserDto представьте в виде строки с датой в формате yyyy.MM.dd, hh:mm:ss.

    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
//            .withZone(ZoneId.systemDefault());
//
//    Instant instant = Instant.parse("2022-02-15T18:35:24.00Z"); // из строки
//    String formattedInstant = formatter.format(instant); // в строку
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd, hh:mm:ss")
            .withZone(ZoneId.systemDefault());

    public UserDto userToDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                formatter.format(user.getRegistrationDate()), user.getState());
    }

    public User dtoToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                Instant.parse(userDto.getRegistrationDate()),
                userDto.getState());
    }

}
