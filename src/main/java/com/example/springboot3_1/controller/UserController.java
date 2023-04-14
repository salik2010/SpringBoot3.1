package com.example.springboot3_1.controller;

import com.example.springboot3_1.entity.User;
import com.example.springboot3_1.service.UserService;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello(Model model) {
        List<User> allUser=userService.getAll();
        model.addAttribute("users",allUser);

        return "index";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("newuser",user);
        return "new";
    }
    @PostMapping("/new")
    public String newUserPost(@ModelAttribute("user") User user){
        userService.newUser(user);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteId(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") Long id,Model model) {
        User user = userService.getById(id);
        model.addAttribute("edituser",user);
        return "edit";
    }
    @PostMapping("/edit")
    public String editUserPost(User user){
        userService.editUser(user);
        return "redirect:/";
    }
}
