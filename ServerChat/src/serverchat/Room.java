/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.util.ArrayList;
import java.util.List;

/**
 * Trabalho 01 - Implementação de Chat
 * Disciplina: Redes e Sistemas Distríbuidos
 * Professora: Aline Vieira de Mello
 * Curso: Engenharia de Software
 *  
 * @version 0.1 - 04/2012
 * @author Juliano Rodovalho, Lucas Capanelli, Renan Uchôa
 */
public class Room {
    
    private List<User> users;
    
    /**
     * Build an Sala object
     */
    public Room() {
        this.users = new ArrayList<User>();
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    /**
     * @param user 
     */
    public void connect(User user) {
        this.users.add(user);
    }
    
    /**
     * @param user 
     */
    public void disconnect(User user) {
        for(User u : this.users) {
            if (user.getNickName().equals(u.getNickName())) {
                users.remove(u);
            }
        }
    }
    
}
