/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

/**
 *
 * @author renanmarceluchoa
 */
public class Usuario {
    
    private String nickName;
    private String ipAdress;
    
    public Usuario() {
        
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
