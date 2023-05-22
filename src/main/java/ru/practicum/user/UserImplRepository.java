package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserImplRepository implements UserRepository {

    HashMap<Long, User> users = new HashMap<>();
    private static Long globalUserId = 1L;

    private Long generateId() {
        return globalUserId++;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public User save(User user) {
        User fullUser = new User(globalUserId, user.getEmail(), user.getName());
        users.put(globalUserId, fullUser);
        return fullUser;
    }
}
