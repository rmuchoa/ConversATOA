/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.Serializable;

/**
 *
 * Trabalho 01 - Implementação de Chat
 * Disciplina: Redes e Sistemas Distríbuidos
 * Professora: Aline Vieira de Mello
 * Curso: Engenharia de Software
 *  
 * @version 0.1 - 04/2012
 * @author Juliano Rodovalho, Lucas , Renan Marcel
 */
public class Message implements Serializable{
    
    private User user;
    private String message;
    private User receiver;
    private boolean authenticated;
    private boolean conected;
    
    public Message() {
        
        this.authenticated = false;
        this.conected = false;
    
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the receiver
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the conStatus
     */
    public boolean isConected() {
        return conected;
    }

    /**
     * @param conectionStatus the conStatus to set
     */
    public void setConected(boolean conected) {
        this.conected = conected;
    }

    /**
     * @return the autentic
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * @param autentic the autentic to set
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
}
