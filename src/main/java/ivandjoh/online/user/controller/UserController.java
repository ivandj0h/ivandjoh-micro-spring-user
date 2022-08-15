package ivandjoh.online.user.controller;

import ivandjoh.online.user.entity.UserMicro;
import ivandjoh.online.user.service.UserService;
import ivandjoh.online.user.valueobjects.ResponseTemplateValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public UserMicro addNewUser(@RequestBody UserMicro user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/user/{id}")
    public ResponseTemplateValueObject getUserWithDepartment(
            @PathVariable("id") Long userId
    ) {
        return userService.getUserWithDepartment(userId);
    }
}
