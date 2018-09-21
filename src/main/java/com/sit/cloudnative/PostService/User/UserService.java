package com.sit.cloudnative.PostService.User;

import java.util.List;
import com.sit.cloudnative.PostService.Post.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();    
    }

    public User getUser(long id){
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Id: " + id));
    }
}