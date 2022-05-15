package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubRepository extends JpaRepository<Publication,Integer> {
     List<Publication> findAllByOrderByPubIdDesc();


}
