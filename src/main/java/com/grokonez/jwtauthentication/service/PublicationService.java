package com.grokonez.jwtauthentication.service;

import com.grokonez.jwtauthentication.model.Publication;
import com.grokonez.jwtauthentication.repository.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicationService {

    @Autowired
    private PubRepository pubRepo;

    public List<Publication> getAllPublications() {
        return pubRepo.findAllByOrderByPubIdDesc();
    }


    public Publication createPublication(Publication pub) {
        return pubRepo.save(pub);
    }

    public void delete(int id) {
        pubRepo.deleteById(id);
    }

    public ResponseEntity<Publication> updatePost(Publication post) {
        Publication pub = pubRepo.getById(post.getPubId());
        if(post.getContenu()!=null) pub.setContenu(post.getContenu());

        pubRepo.save(pub);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
