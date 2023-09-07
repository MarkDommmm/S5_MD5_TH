package ra.model.service;

import ra.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(Long id);
}
