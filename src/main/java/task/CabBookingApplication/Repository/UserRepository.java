package task.CabBookingApplication.Repository;

import org.springframework.stereotype.Component;
import task.CabBookingApplication.Model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
