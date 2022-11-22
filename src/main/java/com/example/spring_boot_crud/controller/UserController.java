package com.example.spring_boot_crud.controller;

import com.example.spring_boot_crud.SpringBootCrudApplication;
import com.example.spring_boot_crud.model.User;
import com.example.spring_boot_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

      @GetMapping("/user")
    public String allUser (Model model) {
       List<User> allUser = userService.getAllUsers();
       model.addAttribute("allUsers", allUser);
        return "allUser";
    }

    @GetMapping("/addUser")
    public String addUser (Model model) {
        User user = new User();
        model.addAttribute("User", user);
        return "UserInfo";
    }

    @PostMapping("/saveUser")
    public String saveUser (@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }
    @GetMapping("/edit/{id}")
    public String updateUser (@PathVariable("id") int id, Model model ){
        User user = userService.getUser(id);
        model.addAttribute("User", user);
        return "UserInfo";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser (@PathVariable ("id") int id){
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
