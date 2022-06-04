package com.webdevelopersbackend.repositories;
import com.webdevelopersbackend.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<UserEntity, Long> {
}
