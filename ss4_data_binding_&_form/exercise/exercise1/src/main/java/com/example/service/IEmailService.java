package com.example.service;

import com.example.controller.EmailController;
import com.example.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> display();

    Email findEmail(int id);

    void updateEmail(Email email);
}
