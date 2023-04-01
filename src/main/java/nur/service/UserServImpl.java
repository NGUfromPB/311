package nur.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nur.dao.UserDao;
import nur.models.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServImpl implements UserServ{
    private final UserDao userDao;
    @Autowired
    public UserServImpl (UserDao userDao) {
        this.userDao=userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findById(long id) {

        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user,long id) {
        user.setUserId(id);
        userDao.save(user);
    }
}
