package task.CabBookingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.CabBookingApplication.Repository.UserRepository;
import task.CabBookingApplication.Model.User;

@Service
public class UserService {
    @Autowired
    UserRepository users;

    public void addUser(String name, String gender, int age) {
        User user = new User();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        users.addUser(user);
    }
}
