/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class ServerChat {

    /**
     * Método que levanta o ServerSocket para receber mensagens dos clients do ConversATOA
     * @param rgs 
     */
    public static void main(String rgs[]) {
        
        try {
            
            int serverPort = 8000;
            ServerSocket server = new ServerSocket(serverPort);
            Room room = new Room();
            
            while (true) {
                Socket client = server.accept();
                new ServerSocketReader(client, room);                
            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " New Client ERROR : " + erro.getMessage());

        }
        
    }
    
}
