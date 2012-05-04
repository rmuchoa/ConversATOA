/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author renanmarceluchoa
 */
public class Room {
    
    private List<User> users;
    
    /**
     * Build an Sala object
     */
    public Room() {
        this.users = new LinkedList<User>();
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
    
    public void connect(User user) {
        this.users.add(user);
    }
    
    public void disconnect(User user) {
        for(User u : this.users) {
            if (user.getNickName().equals(u.getNickName())) {
                users.remove(u);
            }
        }
    }
    
}
