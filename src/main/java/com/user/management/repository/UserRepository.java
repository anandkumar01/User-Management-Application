package com.user.management.repository;

import com.user.management.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);
}
