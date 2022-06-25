package br.com.guiinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.contact.dao.ContactDAO;

public class mainpage {
    private JPanel mainPanel;
    private JButton adicionar;
    private JTextArea textAreaNome;
    private JTextArea textAreaEmail;
    private JTextArea textAreaIdade;
    private JTextArea textAreaData;

    private String data;
    private String idade;
    private String nome;
    private String email;

    public mainpage() {
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nome = textAreaNome.getText();
                    email = textAreaEmail.getText();
                    data = textAreaData.getText();
                    idade = textAreaIdade.getText();

                    ContactDAO.enviarQueryParaBanco("INSERT INTO contacts(nome,idade,email,dataCadastro) VALUES (\""+nome+"\","+idade+",\""+email+"\","+data+");");
                    JOptionPane.showMessageDialog(null,"Query enviada com sucesso!!!");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("mainpage");
        frame.setContentPane(new mainpage().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        new mainpage();
    }
}
