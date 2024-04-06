package me.jeonguk.examples.service;

import me.jeonguk.examples.controller.UserCreateRequest;
import me.jeonguk.examples.domain.UserEntity;
import me.jeonguk.examples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserCreateRequest request) {
        UserEntity user = new UserEntity(request.name());

        userRepository.save(user);
    }

}
