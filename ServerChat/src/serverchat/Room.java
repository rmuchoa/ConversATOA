/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.util.ArrayList;
import java.util.List;

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
public class Room {
    
    private List<User> users;
    
    /**
     * Cria uma sala de bate-papo para que os usuários possam se conectar, conversar e se desconectar
     */
    public Room() {
        this.users = new ArrayList<User>();
    }

    /**
     * @return the users list
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users to set the users list
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    /**
     * Método que conecta um usuário à sala de bate-papo
     * @param user 
     */
    public void connect(User user) {
        this.users.add(user);
    }
    
    /**
     * Método que desconecta um usuário da sala de bate-papo
     * @param user 
     */
    public void disconnect(User user) {
        for(int i=0; i<users.size(); i++) {
            if (user.getNickName().equals(users.get(i).getNickName())) {
                users.remove(i);
            }
        }
    }
    
}
