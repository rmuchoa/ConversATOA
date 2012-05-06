/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import gui.mainChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author renanmarceluchoa
 */
public class ServerSocketRunner extends Thread {
    
    private mainChat chat;
    private int serverPort;
    private ServerSocket server;
    private ClientSocketReader reader;
    
    public ServerSocketRunner(mainChat chat) {
        
        this.chat = chat;
        this.start();
        
    }
    
    public void run() {
        
        try {
        
            this.serverPort = 8001;
            this.server = new ServerSocket(serverPort);
            
            while (true) {
                Socket client = server.accept();
                this.reader = new ClientSocketReader(client);
                String message = reader.getMessage();
                this.chat.receiveMessage(message);
            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " New Client ERROR : " + erro.getMessage());

        }
        
    }
    
}
