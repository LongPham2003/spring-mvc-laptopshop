package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello server controller";
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user) {
        User eric = this.userRepository.save(user);
        return eric;
    }

    public User getByIdUser(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

}
