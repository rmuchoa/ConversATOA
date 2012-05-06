/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * Trabalho 01 - Implementação de Chat Disciplina: Redes e Sistemas Distríbuidos
 * Professora: Aline Vieira de Mello Curso: Engenharia de Software
    *
 * @version 0.1 - 04/2012
 * @author Juliano Rodovalho, Lucas Capanelli, Renan Uchôa
 */
public class ServerSocketReader extends Thread {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket client;
    private User receiver;
    private User user;
    private Room room;

    public ServerSocketReader(Socket client, Room room) {

        try {
            this.input = new DataInputStream(client.getInputStream());
            this.output = new DataOutputStream(client.getOutputStream());
            this.client = client;
            this.room = room;
            this.start();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, " CONNECTION ERROR : " + erro.getMessage());

        }
    }

    @Override
    public void run() {

        try {

            String message = input.readUTF();
            String clientIpAddress = client.getLocalAddress().getHostAddress();
            
            if (isConectedUser(clientIpAddress)) {

                output.writeBoolean(true);
                
                if (isValidReceiver(message)) {
                    
                    user.setReceiver(receiver);
                    
                } else if (isLogoutMessage(message)) {
                    
                    room.disconnect(user);
                    sendMessage(user.getNickName() + " desconectou");
                    
                } else {
                    
                    if (user.getReceiver() == null) {
                        
                        sendMessage(user.getNickName() + " disse: " + message);
                        
                    } else {
                        
                        sendMessage(user.getNickName() + " disse reservadamente: " + message, user.getReceiver().getIpAddress());
                        sendMessage(user.getNickName() + " disse reservadamente: " + message, user.getIpAddress());
                        
                    }
                    
                }

            } else if (isValidUser(message)) {
                
                User user = new User(message, clientIpAddress);
                room.connect(user);
                output.writeBoolean(true);
                sendMessage(user.getNickName() + " conectou");
                
            } else {
                
                output.writeBoolean(false);
                
            }

                    //108.174.58.136:8000 ------ InetAddress.getLocalHost().getHostAddress()
        
        } catch (IOException erro) {

            JOptionPane.showMessageDialog(null, " Input/Output ERROR : " + erro.getMessage());

        }

    }
    
    public boolean isConectedUser(String ipAddress) {
        for (User user : room.getUsers()) {
            if (user.getIpAddress().equals(ipAddress)) {
                this.user = user;
                return true;
            }
        }
        return false;
    }
    
    public boolean isValidUser(String nickName) {
        for (User user : room.getUsers()) {
            if (user.getNickName().equals(nickName)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidReceiver(String nickName) {
        for (User user : room.getUsers()) {
            if (nickName.equals(user.getNickName()) && !nickName.equals(this.user.getNickName())) {
                this.receiver = user;
                return true;
            }
        }
        return false;
    }
    
    public boolean isLogoutMessage(String message) {
        if(message.contains("#out")) {
            return true;
        }
        return false;
    }
    
    public void sendMessage(String message) {
        
        for (User user : room.getUsers()) {
            sendMessage(message, user.getIpAddress());
        }
        
    }
    
    public void sendMessage(String message, String ipAddress) {
        
        try {
            
            int clientPort = 8001;
            Socket resendSocket = new Socket(ipAddress, clientPort);
            SocketSender sender = new SocketSender(resendSocket, message);
            if(sender.getStatus()) {
                System.out.println("A mensagem foi enviada com sucesso: "+message);
            }
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerSocketReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
