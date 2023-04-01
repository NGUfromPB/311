package nur.service;
import nur.models.User;
import java.util.List;
import java.util.Optional;

public interface UserServ {

    List<User> getAllUsers ();
    User findById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user,long id);
}