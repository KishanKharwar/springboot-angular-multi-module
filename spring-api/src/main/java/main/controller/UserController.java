package main.controller;

import java.util.List;
import main.entities.User;
import main.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);
  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @PostMapping("/users")
  void addUser(@RequestBody User user) {
    logger.debug("Adding user : {}", user);
    user.setEmail(user.getName().toLowerCase() + "@domain.com");
    userRepository.save(user);
    System.out.println(user);
  }
}
