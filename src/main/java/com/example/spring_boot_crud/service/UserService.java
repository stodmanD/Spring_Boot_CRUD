package com.example.spring_boot_crud.service;

import com.example.spring_boot_crud.SpringBootCrudApplication;
import com.example.spring_boot_crud.model.User;
import com.example.spring_boot_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void saveUser(User user) {
        userRepository.save(user);
    }


    public User getUser(int id) {
        return userRepository.getOne(id);
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
