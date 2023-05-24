package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ItemImplRepository implements ItemRepository {
    HashMap<Long, Item> items = new HashMap<>();
    private static Long globalItemId = 1L;

    private Long generateId() {
        return globalItemId++;
    }

    @Override
    public List<Item> findByUserId(long userId) {
        List<Item> itemsByUserId = new ArrayList<Item>(items.values());
        return itemsByUserId.stream().filter((x) -> x.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public Item save(Long userId,Item item) {
        Item fullItem = new Item();
        items.put(globalItemId, fullItem);
        return fullItem;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Optional<Item> itemForDelete = new ArrayList<>(items.values()).stream()
                .filter((x) -> x.getUserId() == userId)
                .filter((y) -> y.getId() == itemId)
                .findFirst();
        if (itemForDelete.isPresent()) {
            items.remove(itemForDelete);
        } else {
            System.out.println("Нет такой ссылки у данного пользователя");
        }
    }
}
