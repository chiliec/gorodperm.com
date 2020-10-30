package info.babin.gorodperm.services;

import info.babin.gorodperm.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);
    User save(User user);
    void deleteById(int id);
}
