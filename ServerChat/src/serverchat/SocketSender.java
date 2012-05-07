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
 * @authors Juliano Rodovalho, Lucas Capanelli, Renan Marcel
 */
public class SocketSender {

    private DataInputStream input;
    private DataOutputStream output;
    private String message;
    private boolean status;

    public SocketSender(Socket clientSocket, String message) {

        try {

            this.input = new DataInputStream(clientSocket.getInputStream());
            this.output = new DataOutputStream(clientSocket.getOutputStream());
            this.message = message;
            output.writeUTF(message);
            setStatus(input.readBoolean());
            

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " CONNECTION ERROR : " + erro.getMessage());

        }

    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
