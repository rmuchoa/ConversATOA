/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.IOException;
import java.net.InetAddress;
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

    public static int serverPort;

    /**
     * Constructor of the class ServerChat
     */
    public void ServerChat() {
        
    }

    public static void main(String rgs[]) {

        try {
            
            serverPort = 8000;
            ServerSocket listSocket = new ServerSocket(serverPort);
            Room room = new Room();
            
            /**
             * Captura o endereço do local host, ou sej ao endereço fisico do computador.
             */
//            InetAddress ia = InetAddress.getLocalHost();
//            System.out.println(ia.getHostAddress());
            
            while (true) {

                Socket clientSocket = listSocket.accept();
                new Connection(clientSocket, room);
                
            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " New Client ERROR : " + erro.getMessage());

        }
    }
}
