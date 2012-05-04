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
public class User implements Serializable{
    
    private String nickName;
    private String ipAdress;
    
    public User() {
        
    }

    /**
     * @return the nickname
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the ipAdress
     */
    public String getIpAdress() {
        return ipAdress;
    }

    /**
     * @param ipAdress the ipAdress to set
     */
    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }
    
}
