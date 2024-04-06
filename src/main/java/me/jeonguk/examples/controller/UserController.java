package me.jeonguk.examples.controller;

import me.jeonguk.examples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void createUser(
            @RequestBody UserCreateRequest request
    ) {
        userService.createUser(request);
    }

    @PutMapping("/users/{userId}")
    public void updateUserEmail(
            @PathVariable Long userId,
            @RequestBody UserUpdateRequest request

    ) {
        userService.updateUserEmail(userId, request);
    }

}
