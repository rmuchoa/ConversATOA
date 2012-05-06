/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import gui.mainChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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
                
                if (message.contains("conectou")) {
                    
                    String nickname = message.substring(0, message.indexOf(" ")-1);
                    if (!nickname.equals(chat.getNickname())) {
                        final String[] temp = new String[chat.getJList_loggedUsers().getModel().getSize() + 1];
                        temp[0] = nickname;
                        for(int i=1; i<chat.getJList_loggedUsers().getModel().getSize(); i++) {
                            temp[i] = (String) chat.getJList_loggedUsers().getModel().getElementAt(i);
                        }
                        chat.getJList_loggedUsers().setModel(new javax.swing.AbstractListModel() {
                            String[] strings = temp;
                            public int getSize() { return strings.length; }
                            public Object getElementAt(int i) { return strings[i]; }
                        });
                    }
                    
                } else if (message.contains("desconectou")) {
                    
                    String nickname = message.substring(0, message.indexOf(" ")-1);
                    
                    final List<String> temp = new ArrayList<String>();
                    for(int i=0; i<chat.getJList_loggedUsers().getModel().getSize(); i++) {
                        if (!nickname.equals((String) chat.getJList_loggedUsers().getModel().getElementAt(i))) {
                            temp.add((String) chat.getJList_loggedUsers().getModel().getElementAt(i));
                        }
                    }
                    chat.getJList_loggedUsers().setModel(new javax.swing.AbstractListModel() {
                        String[] strings = (String[]) temp.toArray();
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                    });
                    
                } else if (message.contains("#nicknames")) {
                
                    final List<String> names = new ArrayList<String>();
                    int i=0;
                    while (!message.isEmpty()) {
                        
                        int divisor = message.indexOf("\n");
                        String nickname = message.substring(0, divisor-1);
                        if (!nickname.equals(chat.getNickname()) && i>0) {
                            names.add(nickname);
                        }
                        message = message.substring(divisor+2);
                        i++;
                        
                    }
                    
                    chat.getJList_loggedUsers().setModel(new javax.swing.AbstractListModel() {
                        String[] strings = (String[]) names.toArray();
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                    });
                    
                }
                
            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " New Client ERROR : " + erro.getMessage());

        }
        
    }
    
}
