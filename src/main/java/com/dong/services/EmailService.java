package com.dong.services;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by DONG on 10/3/2017.
 */
public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs);

    /*void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);*/
}
