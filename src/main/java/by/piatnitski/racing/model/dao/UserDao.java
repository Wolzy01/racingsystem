package by.piatnitski.racing.model.dao;

import by.piatnitski.racing.model.entity.User;

public interface UserDao {
    User findById(Long id);
    User findByUsername(String username); // исправлено имя метода
    void save(User user);
    void update(User user);
    void delete(Long id);
}