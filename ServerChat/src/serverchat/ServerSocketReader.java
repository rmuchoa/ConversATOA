
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * Trabalho 01 - Implementação de Chat 
 * Disciplina: Redes e Sistemas Distríbuidos
 * Professora: Aline Vieira de Mello 
 * Curso: Engenharia de Software
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

    /**
     * Cria uma Thread responsável por ouvir mensagens do ClientChat, e interpretá-las de acordo com a lista de usuários logados na sala
     * @param client
     * @param room 
     */
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

    /**
     * Método que verifica a mensagem recebida para direcionar o usuário ao caminho correto
     */
    @Override
    public void run() {

        try {

            String message = input.readUTF();
            String clientIpAddress = client.getInetAddress().getHostAddress();
            
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
                sendUserList(room, user);
                
            } else {
                
                output.writeBoolean(false);
                
            }
        
        } catch (IOException erro) {

            JOptionPane.showMessageDialog(null, " Input/Output ERROR : " + erro.getMessage());

        }

    }
    
    /**
     * Método que verifica se o ipAddress recebido representa um usuário logado no sistema
     * @param ipAddress
     * @return 
     */
    public boolean isConectedUser(String ipAddress) {
        for (User user : room.getUsers()) {
            if (user.getIpAddress().equals(ipAddress)) {
                this.user = user;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que interpreta se o nickName recebido está disponível para ser utilizado por um novo usuário.
     * @param nickName
     * @return 
     */
    public boolean isValidUser(String nickName) {
        for (User user : room.getUsers()) {
            if (user.getNickName().equals(nickName)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método que interpreta se o nickName recebido representa um destinatário válido conectado na sistema.
     * @param nickName
     * @return 
     */
    public boolean isValidReceiver(String nickName) {
        for (User user : room.getUsers()) {
            if (nickName.equals(user.getNickName()) && !nickName.equals(this.user.getNickName())) {
                this.receiver = user;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que interpreta se a mensagem recebida representa uma mensagem de logout
     * @param message
     * @return 
     */
    public boolean isLogoutMessage(String message) {
        if(message.contains("#out")) {
            return true;
        }
        return false;
    }
    
    /**
     * Método que envia uma mensagem recebida para cada um dos usuários listados na sala de bate-papo
     * @param message 
     */
    public void sendMessage(String message) {
        
        for (User user : room.getUsers()) {
            sendMessage(message, user.getIpAddress());
        }
        
    }
    
    /**
     * Método que envia a mensagem recebida para o ipAddress informado via Socket
     * @param message
     * @param ipAddress 
     */
    public void sendMessage(String message, String ipAddress) {
        
        try {
            
            int clientPort = 8001;
            Socket resendSocket = new Socket(ipAddress, clientPort);
            SocketSender sender = new SocketSender(resendSocket, message);
            if(sender.getStatus()) {
                
                System.out.println("A mensagem foi enviada com sucesso: "+message);
            
            }else {
                //implementar um laço para continuar tentando enviar a mensagem
                System.out.println("A mensagem não chegou ao destino.");
                
            }
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerSocketReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método que envia uma menssagem com uma lista de todos os usuários logados no sistema
     * @param room
     * @param user 
     */
    public void sendUserList(Room room, User user) {
        
        try {
            
            String message = "#nicknames" + "\n";
            
            for (User u : room.getUsers()) {
                message += u.getNickName() + "\n";
            }
            
            int clientPort = 8001;
            Socket resendSocket = new Socket(user.getIpAddress(), clientPort);
            SocketSender sender = new SocketSender(resendSocket, message);
            
            if(sender.getStatus()) {
                
                System.out.println("A mensagem foi enviada com sucesso: "+message);
                
            } else {
                //implementar um laço para continuar tentando enviar a mensagem
                System.out.println("A mensagem não chegou ao destino");

            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerSocketReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerSocketReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
