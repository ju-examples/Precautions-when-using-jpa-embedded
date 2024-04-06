package me.jeonguk.examples.repository;

import me.jeonguk.examples.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
}
