package com.developersview.SpringSecurityExample.repository;

import com.developersview.SpringSecurityExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pranoy.chakraborty
 * @Date 31/07/22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
