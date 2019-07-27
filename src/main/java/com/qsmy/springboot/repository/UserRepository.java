package com.qsmy.springboot.repository;

import com.qsmy.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qsmy
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
