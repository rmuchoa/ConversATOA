/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import serverchat.*;

/**
 *
 * @author Lucas
 */
public class mainChat extends javax.swing.JFrame {

    private ClientSocketReader reader;
    
    /**
     * Creates new form mainChat
     */
    public mainChat() {
        initComponents();
        this.setVisible(true);
        loadServerSocketRunner();
        
        jTextArea_userInputText.setEnabled(false);
        jButton_sendMessage.setEnabled(false);
        jButton_logOut.setEnabled(false);
        
    }
    
    public void loadServerSocketRunner() {
        
        new ServerSocketRunner(this);
        
    }
    
    public boolean sendMessage(String message) {

        try {
            
            int serverPort = 8000;
            String ipServer = InetAddress.getByName("localhost").getHostAddress();
            Socket clientSocket = new Socket(ipServer, serverPort);
            SocketSender sender = new SocketSender(clientSocket, message);
            return sender.getStatus();

        } catch (IOException erro) {
           
            JOptionPane.showMessageDialog(null, " SEND MESSAGE ERROR : " + erro.getMessage());

        }

        return false;

    }
    
    public void receiveMessage(String message) {
        
        jTextArea_mainChat.setText(jTextArea_mainChat.getText() + "\n" + message);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel_chatBoard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_mainChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_userInputText = new javax.swing.JTextArea();
        jTextField_userNickname = new javax.swing.JTextField();
        jLabel_nickName = new javax.swing.JLabel();
        jButton_logIn = new javax.swing.JButton();
        jPanel_userListBoard = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_loggedUsers = new javax.swing.JList();
        jLabel_loggedUsers = new javax.swing.JLabel();
        jButton_sendMessage = new javax.swing.JButton();
        jButton_logOut = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea_mainChat.setColumns(20);
        jTextArea_mainChat.setEditable(false);
        jTextArea_mainChat.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea_mainChat.setRows(5);
        jScrollPane1.setViewportView(jTextArea_mainChat);

        jTextArea_userInputText.setColumns(20);
        jTextArea_userInputText.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea_userInputText.setRows(5);
        jScrollPane2.setViewportView(jTextArea_userInputText);

        jTextField_userNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_userNicknameActionPerformed(evt);
            }
        });

        jLabel_nickName.setText("Apelido");

        jButton_logIn.setText("Logar");
        jButton_logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_chatBoardLayout = new javax.swing.GroupLayout(jPanel_chatBoard);
        jPanel_chatBoard.setLayout(jPanel_chatBoardLayout);
        jPanel_chatBoardLayout.setHorizontalGroup(
            jPanel_chatBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(jPanel_chatBoardLayout.createSequentialGroup()
                .addComponent(jLabel_nickName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_userNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_logIn)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel_chatBoardLayout.setVerticalGroup(
            jPanel_chatBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_chatBoardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_chatBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_userNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nickName)
                    .addComponent(jButton_logIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jList_loggedUsers.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jList_loggedUsers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList_loggedUsers);

        jLabel_loggedUsers.setText("Usuários logados");

        javax.swing.GroupLayout jPanel_userListBoardLayout = new javax.swing.GroupLayout(jPanel_userListBoard);
        jPanel_userListBoard.setLayout(jPanel_userListBoardLayout);
        jPanel_userListBoardLayout.setHorizontalGroup(
            jPanel_userListBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel_userListBoardLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel_loggedUsers)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel_userListBoardLayout.setVerticalGroup(
            jPanel_userListBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_userListBoardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_loggedUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton_sendMessage.setText("Enviar");
        jButton_sendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sendMessageActionPerformed(evt);
            }
        });

        jButton_logOut.setText("Deslogar");
        jButton_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_chatBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_userListBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_sendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_logOut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_chatBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_userListBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_sendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_logOut))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_sendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sendMessageActionPerformed

        try {

            String message = jTextArea_userInputText.getText();

            Boolean status = sendMessage(message);

            if (!status) {
                
                System.out.println("mensagem não pode ser enviada");
                
            }

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, " New user ERROR : " + erro.getMessage());
        }

    }//GEN-LAST:event_jButton_sendMessageActionPerformed

    private void jButton_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_logOutActionPerformed

    private void jButton_logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logInActionPerformed

        try {

            String nickName = jTextField_userNickname.getText();
            String ipClient = InetAddress.getByName("localhost").getHostAddress();
            
            boolean status = sendMessage(nickName);

            if (status) {

                /**
                 * Libera os botões para a utilização do chat.
                 */
                jTextArea_userInputText.setEnabled(true);
                jButton_sendMessage.setEnabled(true);
                jButton_logOut.setEnabled(true);
                /**
                 * Desabilita as opções de login.
                 */
                jTextField_userNickname.setEnabled(false);
                jButton_logIn.setEnabled(false);
                

            } else {

                jTextArea_mainChat.setText(jTextArea_mainChat.getText() + "\n" + " o nickname " + nickName + " já está sendo usado");
            }


        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, " New user ERROR : " + erro.getMessage());
        }

    }//GEN-LAST:event_jButton_logInActionPerformed

    private void jTextField_userNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_userNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_userNicknameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new mainChat();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_logIn;
    private javax.swing.JButton jButton_logOut;
    private javax.swing.JButton jButton_sendMessage;
    private javax.swing.JLabel jLabel_loggedUsers;
    private javax.swing.JLabel jLabel_nickName;
    private javax.swing.JList jList_loggedUsers;
    private javax.swing.JPanel jPanel_chatBoard;
    private javax.swing.JPanel jPanel_userListBoard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea_mainChat;
    private javax.swing.JTextArea jTextArea_userInputText;
    private javax.swing.JTextField jTextField_userNickname;
    // End of variables declaration//GEN-END:variables

}
