package com.grokonez.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import com.grokonez.jwtauthentication.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


    Optional<User> findByEmail(String email);

    void deleteByEmail(String  email);

    long countByTypeSang(String typeSang);

    List<User> findAllByRolesName(RoleName role);


}