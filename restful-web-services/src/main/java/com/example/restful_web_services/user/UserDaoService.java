package com.example.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "홍길동", LocalDate.now().minusYears(30)));
        users.add(new User(2, "홍동", LocalDate.now().minusYears(25)));
        users.add(new User(3, "홍길", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
}
