package me.jeonguk.examples.service;

import me.jeonguk.examples.controller.UserCreateRequest;
import me.jeonguk.examples.controller.UserDetailResponse;
import me.jeonguk.examples.controller.UserUpdateRequest;
import me.jeonguk.examples.domain.Email;
import me.jeonguk.examples.domain.UserEntity;
import me.jeonguk.examples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
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

    public UserDetailResponse getUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new UserDetailResponse(user.getId(), user.getName(), user.getFullEmail());
    }

    @Transactional
    public void updateUserEmail(Long userId, UserUpdateRequest request) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updateEmail(Email.of(request.fullEmail()));
    }

}
