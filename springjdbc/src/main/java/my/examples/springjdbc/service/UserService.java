package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.User;

public interface UserService {
    public User addUser(User user);
    public User getUserByEmail(String email);
}
