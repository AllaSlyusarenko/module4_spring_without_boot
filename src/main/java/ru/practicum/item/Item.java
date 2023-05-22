package ru.practicum.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Item {

    private Long id;
    private Long userId;
    private String url;
}