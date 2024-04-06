package me.jeonguk.examples.service;

import me.jeonguk.examples.controller.UserCreateRequest;
import me.jeonguk.examples.controller.UserUpdateRequest;
import me.jeonguk.examples.domain.Email;
import me.jeonguk.examples.domain.UserEntity;
import me.jeonguk.examples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(UserCreateRequest request) {
        UserEntity user = new UserEntity(request.name());

        userRepository.save(user);
    }

    @Transactional
    public void updateUserEmail(Long userId, UserUpdateRequest request) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        user.updateEmail(Email.of(request.fullEmail()));
    }

}
