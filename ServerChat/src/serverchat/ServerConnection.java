/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

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
class ServerConnection extends Thread {

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket clientSocket;
    private Room room;

    public ServerConnection(Socket clientSocket, Room room) {

        try {

            this.input = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Trollo o input...");
            this.output = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("Trollo o output...");
            this.clientSocket = clientSocket;
            this.room = room;
            this.start();
            System.out.println("Trollo a thread...");

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, " CONNECTION ERROR : " + erro.getMessage());

        }

    }

    @Override
    public void run() {

        try {

            Message message = (Message) input.readObject();
            if (message.isConected() && !message.isAuthenticated()) {

                this.room.connect(message.getUser());

            } else if (message.isConected() && message.isAuthenticated()) {

                if (message.getReceiver() == null) {

                    for (User user : room.getUsers()) {
                        int clientPort = 8000;
                        Socket resendSocket = new Socket(user.getIpAdress(), clientPort);
                        ObjectInputStream in = new ObjectInputStream(resendSocket.getInputStream());
                        ObjectOutputStream out = new ObjectOutputStream(resendSocket.getOutputStream());

                        out.writeObject(message);

                        boolean status = in.readBoolean();
                        System.out.println("Message received by client: " + message.getMessage());
                    }

                    //108.174.58.136:8000 ------ InetAddress.getLocalHost().getHostAddress()

                } else {

                    int clientPort = 8000;
                    Socket resendSocket = new Socket(message.getReceiver().getIpAdress(), clientPort);
                    ObjectInputStream in = new ObjectInputStream(resendSocket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(resendSocket.getOutputStream());

                    out.writeObject(message);

                    boolean status = in.readBoolean();
                    if (status) {
                        System.out.println("Message received by client: " + message.getMessage());
                    }

                    clientPort = 8000;
                    resendSocket = new Socket(message.getReceiver().getIpAdress(), clientPort);
                    in = new ObjectInputStream(resendSocket.getInputStream());
                    out = new ObjectOutputStream(resendSocket.getOutputStream());

                    out.writeObject(message);

                    status = in.readBoolean();
                    if (status) {
                        System.out.println("Message received by client: " + message.getMessage());
                    }

                }

            } else if (!message.isConected()) {

                this.room.disconnect(message.getUser());

            }
            output.writeObject(message);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException erro) {

            JOptionPane.showMessageDialog(null, " Input/Output ERROR : " + erro.getMessage());

        }

    }
}
