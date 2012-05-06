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
import java.util.Date;
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
public class ClientSocketReader extends Thread {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket server;
    private String message;

    public ClientSocketReader(Socket server) {

        try {
            
            this.input = new DataInputStream(server.getInputStream());
            this.output = new DataOutputStream(server.getOutputStream());
            this.server = server;
            this.start();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, " CONNECTION ERROR : " + erro.getMessage());

        }
        
    }

    @Override
    public void run() {

        try {
            
            this.setMessage(input.readUTF());
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClientSocketReader.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
