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
 * @authors Juliano Rodovalho, Lucas Capanelli, Renan Marcel
 */
public class User implements Serializable{
    
    private String nickName;
    private String ipAddress;
    private User receiver;
    private static final long serialVersionUID = 1L;
    
    /**
     * Cria um usuário com um nickName e um ipAddress
     * @param nickName
     * @param ipAddress 
     */
    public User(String nickName, String ipAddress) {
        this.nickName = nickName;
        this.ipAddress = ipAddress;
    }

    /**
     * @return the nickname
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickname to set the nickname
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the ipAdress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAdress to set the ipAdress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the receiver
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * @param receiver to set the receiver
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    
}
