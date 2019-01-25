package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 선언, 컴포넌트 스캔으로 아래 객체는 모두 스프링이 관리한다.
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    /*public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    @Transactional
    public User addUser(User user) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return null;
    }
}
