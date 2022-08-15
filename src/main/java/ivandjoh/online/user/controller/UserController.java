package ivandjoh.online.user.controller;

import ivandjoh.online.user.entity.UserMicro;
import ivandjoh.online.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public UserMicro addNewUser(@RequestBody UserMicro user) {
        return userService.addNewUser(user);
    }
}
