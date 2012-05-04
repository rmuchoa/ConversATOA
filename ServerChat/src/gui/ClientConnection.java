/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import serverchat.*;
import java.io.IOException;
import java.io.InputStream;
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
    private boolean status;

    public ClientConnection(Socket clientSocket, Message message) {

        InputStream teste;

        try {
            System.out.println("Construtor do ClientConnection : " + clientSocket.getInetAddress().getHostAddress());

            teste = clientSocket.getInputStream();
            System.out.println("recebeu o InputStream.");

            this.input = new ObjectInputStream(teste);
            System.out.println("imput criado.");
            this.output = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("output criado.");
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
            this.setStatus(input.readBoolean());
            if (isStatus()) {
                System.out.println("Message received by server: " + message.getMessage());
            }

        } catch (IOException erro) {

            JOptionPane.showMessageDialog(null, " Input/Output ERROR : " + erro.getMessage());

        }

    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
