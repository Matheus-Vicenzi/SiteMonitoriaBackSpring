package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mentorId;



    @ForeignKey()
    private User user;
}

