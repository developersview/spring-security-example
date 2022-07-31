package com.developersview.SpringSecurityExample.repository;

import com.developersview.SpringSecurityExample.model.Role;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pranoy.chakraborty
 * @Date 31/07/22
 */
@Qualifier("roles")
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
