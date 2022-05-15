package com.grokonez.jwtauthentication.service;

import com.grokonez.jwtauthentication.model.ConfirmationEmail;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ConfirmationService {

    @Autowired
    private ConfirmationRepository confirmationRepository;

    public void saveConfirmationEmail(ConfirmationEmail confirmationEmail){
        confirmationRepository.save(confirmationEmail);
    }


    public int setConfirmedAt(String email) {
        return confirmationRepository.updateConfirmedAt(
                email, LocalDateTime.now());
    }

    public Optional<ConfirmationEmail> findConfirmationByEmail(String email){
        return confirmationRepository.findByEmail(email);
    }
}

