/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import serverchat.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
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
class ClientConnection extends Thread {

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket clientSocket;
    private Message message;

    ClientConnection(Socket clientSocket, Message message) {

        try {

            this.input = new ObjectInputStream(clientSocket.getInputStream());
            this.output = new ObjectOutputStream(clientSocket.getOutputStream());
            this.clientSocket = clientSocket;
            this.start();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " CONNECTION ERROR : " + erro.getMessage());

        }

    }

    @Override
    public void run() {

        try {
            output.writeObject(message);
            boolean status = input.readBoolean();
            if (status) {
                System.out.println("Message received by server: " + message.getMessage());
            }

        } catch (IOException erro) {

            JOptionPane.showMessageDialog(null, " Input/Output ERROR : " + erro.getMessage());

        }

    }
}
