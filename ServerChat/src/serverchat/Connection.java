/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
 * @author Juliano Rodovalho, Lucas , Renan Marcel
 */
class Connection extends Thread {

    DataInputStream input;
    DataOutputStream output;
    Socket clientSocket;

    Connection(Socket clientSocket) {

        try {

            this.clientSocket = clientSocket;
            input = new DataInputStream(clientSocket.getInputStream());
            output = new DataOutputStream(clientSocket.getOutputStream());
            this.start();


        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " CONNECTION ERROR : " + erro.getMessage());

        }

    }

    @Override
    public void run() {

        try {
            
            /**
             * Destined of future implementation....
             */
            
        } catch (IOException erro) {

            JOptionPane.showMessageDialog(null, " Input/Output ERROR : " + erro.getMessage());

        }

    }
}
