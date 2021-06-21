package net.rebuyboy.hhanalyzer.controller;

import net.rebuyboy.hhanalyzer.security.MyUserDetails;
import net.rebuyboy.hhanalyzer.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        MyUserDetails appUserDetails = getAppUserDetails();
        model.addAttribute("user",appUserDetails);
        return "index";
    }

    private MyUserDetails getAppUserDetails() {
        return (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
