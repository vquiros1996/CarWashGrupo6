/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CarWashGrupo6.service;
import jakarta.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author Vivian
 */
public interface CorreoService {
    
    public void enviarCorreoHtml(String para, String asunto, String contenidoHtml)
            throws MessagingException;
    
}
