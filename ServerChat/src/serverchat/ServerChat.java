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
 * @author Juliano Rodovalho, Lucas , Renan Marcel
 */
public class ServerChat {

    static int serverPort;

    /**
     * Construtor da classes ServerChat
     */
    public void ServerChat() {
    }

    public static void main(String rgs[]) {

        try {
            
            serverPort = 8080;
            ServerSocket listaSocket = new ServerSocket(serverPort);

            while (true) {

                Socket clienteSocket = listaSocket.accept();
                Conexao conetctar = new Conexao(clienteSocket);

            }

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " ERRO : " + erro.getMessage());

        }
    }
}
