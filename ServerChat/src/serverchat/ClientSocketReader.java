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
 * Trabalho 01 - Implementação de Chat 
 * Disciplina: Redes e Sistemas Distríbuidos
 * Professora: Aline Vieira de Mello 
 * Curso: Engenharia de Software
 *
 * @version 0.1 - 04/2012
 * @authors Juliano Rodovalho, Lucas Capanelli, Renan Marcel
 */
public class ClientSocketReader {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket server;
    private String message;

    public ClientSocketReader(Socket server) {

        try {
            
            this.input = new DataInputStream(server.getInputStream());
            this.output = new DataOutputStream(server.getOutputStream());
            this.server = server;
            this.setMessage(input.readUTF());

            if (message == null || message.equals("")) {
                
                this.output.writeBoolean(false);
            
            }else{
                
                this.output.writeBoolean(true);
            
            }
        
        } catch (Exception erro) {
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
    
}
