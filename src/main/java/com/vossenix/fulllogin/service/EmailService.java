package com.vossenix.fulllogin.service;

//send email to potential user
//link that will allow that user sets a password

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    //this method will run in background
    @Async
    public void sendEmail(String to, String subject, String message){
        SimpleMailMessage registrationEmail = new SimpleMailMessage();

        registrationEmail.setTo(to);
        registrationEmail.setSubject(subject);
        registrationEmail.setText(message);

        mailSender.send(registrationEmail);
    }
}
