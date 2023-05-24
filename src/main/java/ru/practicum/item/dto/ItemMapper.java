package ru.practicum.item.dto;

import ru.practicum.item.Item;

public class ItemMapper {

    public ItemDto itemToDto(Item item) {
        return new ItemDto(item.getId(), item.getUserId(), item.getUrl(), item.getTags());
    }

    public Item dtoToItem(ItemDto itemDto) {
        return new Item(itemDto.getId(), itemDto.getUserId(), itemDto.getUrl(), itemDto.getTags());
    }
}
