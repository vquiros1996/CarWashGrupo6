
package com.CarWashGrupo6.service;

import jakarta.mail.MessagingException;



/**
 *
 * @author Vivian
 */
public interface CorreoService {
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}
