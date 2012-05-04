/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

/**
 *
 * @author renanmarceluchoa
 */
public class Message {
    
    private User user;
    private String message;
    private boolean authenticated;
    private boolean conectionStatus;
    
    public Message() {
    
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
     * @return the conStatus
     */
    public boolean isConectionStatus() {
        return conectionStatus;
    }

    /**
     * @param conectionStatus the conStatus to set
     */
    public void setConectionStatus(boolean conectionStatus) {
        this.conectionStatus = conectionStatus;
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
