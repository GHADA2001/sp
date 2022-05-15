package com.grokonez.jwtauthentication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Publication implements Serializable {
    @Id
    @SequenceGenerator(name = "pub_sequence", sequenceName = "pub_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pub_sequence")
    private int pubId;
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private User appUserId;
    private String contenu;
    @Column(nullable = true)
    private String comments;
    @Column(nullable = true)
    private String image;

}
