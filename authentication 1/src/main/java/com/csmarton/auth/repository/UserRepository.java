package com.csmarton.auth.repository;

import com.csmarton.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    User findByUsernameAndPassword(String userName, String password);
}
