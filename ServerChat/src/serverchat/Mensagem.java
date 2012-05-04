/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

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
public class Mensagem {
    
    private Usuario user;
    private String message;
    private boolean conStatus;
    private boolean autentic;
    
    public Mensagem() {
    
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
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
     * @return the conStatus
     */
    public boolean isConStatus() {
        return conStatus;
    }

    /**
     * @param conStatus the conStatus to set
     */
    public void setConStatus(boolean conStatus) {
        this.conStatus = conStatus;
    }

    /**
     * @return the autentic
     */
    public boolean isAutentic() {
        return autentic;
    }

    /**
     * @param autentic the autentic to set
     */
    public void setAutentic(boolean autentic) {
        this.autentic = autentic;
    }
    
}
