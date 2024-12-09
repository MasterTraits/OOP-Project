package com.projectoop.serverbackend;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  
  public List<User> Allusers() {
    return userRepository.findAll();
  }

  public Optional<User> singleUser(ObjectId id) {
    return userRepository.findById(id);
  }

}

