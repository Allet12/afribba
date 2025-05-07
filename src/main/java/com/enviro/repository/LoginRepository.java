package com.enviro.repository;

import com.enviro.domain.LoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginAttempt, Long> {
}
