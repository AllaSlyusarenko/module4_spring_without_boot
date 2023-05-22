package ru.practicum.item;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
public interface ItemService {

    public List<Item> getItems(long userId);

    public Item addNewItem(long userId, Item item);

    public void deleteItem(long userId, long itemId);
}