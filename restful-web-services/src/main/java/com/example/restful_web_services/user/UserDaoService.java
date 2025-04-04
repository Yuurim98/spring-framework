package com.example.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "홍길동", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "홍동", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "홍길", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
