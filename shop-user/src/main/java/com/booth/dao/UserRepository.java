package com.booth.dao;

import com.booth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: UserRepository
 * @Description:TODO
 * @Version:1.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
