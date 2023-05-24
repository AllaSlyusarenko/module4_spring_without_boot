package ru.practicum.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private Long userId;
    private String url;
    private Set<String> tags = new HashSet<>();


}
