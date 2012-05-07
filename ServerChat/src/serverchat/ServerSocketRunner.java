/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import gui.ClientChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * Trabalho 01 - Implementação de Chat 
 * Disciplina: Redes e Sistemas Distríbuidos
 * Professora: Aline Vieira de Mello 
 * Curso: Engenharia de Software
 *
 * @version 0.1 - 04/2012
 * @authors Juliano Rodovalho, Lucas , Renan Marcel
 */
public class ServerSocketRunner extends Thread {
    
    private ClientChat chat;
    private int serverPort;
    private ServerSocket server;
    private ClientSocketReader reader;
    
    /**
     * Cria uma Thread responsável por levantar um ServerSocket no ClientChat para manipular mensagens recebidas
     * @param chat 
     */
    public ServerSocketRunner(ClientChat chat) {
        
        this.chat = chat;
        this.start();
        
    }
    
    /**
     * Método que verifica a mensagem recebida para manipular adequadamente a interface do ClientChat.
     */
    @Override
    public void run() {
        
        try {
        
            this.serverPort = 8001;
            this.server = new ServerSocket(serverPort);
            
            while (true) {
                Socket client = server.accept();
                this.reader = new ClientSocketReader(client);
                String message = reader.getMessage();
                
                if (message.contains("conectou")) {
                    //printa a mensagem de conexão, e atualiza a lista de usuários logados
                    this.chat.receiveMessage(message);
                    String nickname = message.substring(0, message.indexOf(" "));
                    if (!nickname.equals(chat.getNickname())) {
                        final String[] temp = new String[chat.getJList_loggedUsers().getModel().getSize() + 1];
                        temp[temp.length-1] = nickname;
                        for(int i=0; i<chat.getJList_loggedUsers().getModel().getSize(); i++) {
                            temp[i] = (String) chat.getJList_loggedUsers().getModel().getElementAt(i);
                        }
                        chat.getJList_loggedUsers().setModel(new javax.swing.AbstractListModel() {
                            String[] strings = temp;
                            public int getSize() { return strings.length; }
                            public Object getElementAt(int i) { return strings[i]; }
                        });
                    }
                    
                } else if (message.contains("desconectou")) {
                    //printa a mensagem de desconexão, e atualiza a lista de usuários logados
                    this.chat.receiveMessage(message);
                    String nickname = message.substring(0, message.indexOf(" "));
                    final List<String> temp = new ArrayList<String>();
                    for(int i=0; i<chat.getJList_loggedUsers().getModel().getSize(); i++) {
                        if (!nickname.equals((String) chat.getJList_loggedUsers().getModel().getElementAt(i))) {
                            temp.add((String) chat.getJList_loggedUsers().getModel().getElementAt(i));
                        }
                    }
                    chat.getJList_loggedUsers().setModel(new javax.swing.AbstractListModel() {
                        String[] strings = toArray(temp);
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                    });
                    
                } else if (message.contains("#nicknames")) {
                    //atualiza uma lista inicial de usuários logados
                    final List<String> names = new ArrayList<String>();
                    int i=0;
                    while (!message.isEmpty()) {
                        
                        int divisor = message.indexOf("\n");
                        String nickname = message.substring(0, divisor);
                        if (!nickname.equals(chat.getNickname()) && i>0) {
                            names.add(nickname);
                        }
                        message = message.substring(divisor+1);
                        i++;
                        
                    }
                    
                    chat.getJList_loggedUsers().setModel(new javax.swing.AbstractListModel() {
                        String[] strings = toArray(names);
                        public int getSize() { return strings.length; }
                        public Object getElementAt(int i) { return strings[i]; }
                    });
                    
                } else {
                    
                    this.chat.receiveMessage(message);
                    
                }
                
            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " New Client ERROR : " + erro.getMessage());

        }
        
    }
    
    /**
     * Método que transforma uma lista de Strings em um array de Strings
     * @param list
     * @return 
     */
    public String[] toArray(List<String> list) {
        
        String[] array = new String[list.size()];
        for (int i=0; i<array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
        
    }
    
}
