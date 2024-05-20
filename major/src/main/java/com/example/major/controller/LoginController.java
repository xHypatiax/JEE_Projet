package com.example.major.controller;

import com.example.major.configuration.PasswordEncoderConfig;
import com.example.major.global.GlobalData;
import com.example.major.model.Role;
import com.example.major.model.User;
import com.example.major.repository.RoleRepository;
import com.example.major.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder ;
    @Autowired
    UserRepository userRepository ;
    @Autowired
    RoleRepository roleRepository ;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        User user  = new User();
        model.addAttribute("user",user);
        System.out.println(user);
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user){

        System.out.println(user);

        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
//        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        User reg = userRepository.save(user);
//
//        request.login(user.getEmail(),password);
        return "redirect:/login";

    }








}
