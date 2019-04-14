package com.qsmy.springboot.repository;

import com.qsmy.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
