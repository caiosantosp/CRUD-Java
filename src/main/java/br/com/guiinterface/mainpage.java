package br.com.guiinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.contact.dao.ContactDAO;
import br.com.contact.model.Contact;

public class mainpage {
    private JPanel mainPanel;
    private JButton adicionar;
    private JTextArea textAreaNome;
    private JTextArea textAreaEmail;
    private JTextArea textAreaIdade;
    private JTextArea textAreaData;

    private Date data;
    private int idade;
    private String nome;
    private String email;

    public mainpage() {
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date data = new Date();
                    nome = textAreaNome.getText();
                    email = textAreaEmail.getText();
                    idade = Integer.parseInt(textAreaIdade.getText());

                    Contact contato = new Contact(nome,idade,email,data);

                    /**Data não está salvando corretamente**/
                    /**Data não está salvando corretamente**/
                    /**Data não está salvando corretamente**/

                    ContactDAO.salvarContato(contato);

                    JOptionPane.showMessageDialog(null,"Dados adicionados com sucesso!!!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void paginaAdicionarContato(){
        JFrame frame = new JFrame("Adicionar contato");
        frame.setPreferredSize(new Dimension(300,400));
        frame.setContentPane(new mainpage().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        new mainpage();
    }

    public static Date retornarDataValida(String dataAntiga) throws ParseException {
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD");
        Date novaData = format.parse(dataAntiga);
        return novaData;
    }

    public static void main(String[] args) {
        paginaAdicionarContato();
    }
}
