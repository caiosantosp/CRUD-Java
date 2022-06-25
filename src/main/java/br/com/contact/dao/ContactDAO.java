package br.com.contact.dao;

import br.com.connection.model.Connector;
import br.com.contact.model.Contact;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    // CREATE
    public static void salvarContato(Contact contato) throws Exception {

        // Query que será inserida no banco de dados
        String sql = "INSERT INTO contacts(nome,idade,email,dataCadastro) VALUES (?,?,?,?)";


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Connector.connectToDatabase();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setInt(2,contato.getIdade());
            preparedStatement.setString(3, contato.getEmail());
            preparedStatement.setDate(4,new Date(contato.getDataDeCadastro().getTime()));

            preparedStatement.execute();

            System.out.println("Contato salvo com sucesso!!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    // DELETE
    public static void deletarContato(int id) throws Exception {
        String sql = "delete from heroku_0bea6e542aeaf76.contacts where id=?;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Connector.connectToDatabase();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(connection!=null){
                    connection.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    // READ
    public static void mostrarTodosContatos() throws Exception {
        String sql = "select * from heroku_0bea6e542aeaf76.contacts;";

        List<Contact> contacts = new ArrayList<Contact>();

        Connection connection = null;
        PreparedStatement prepared = null;
        ResultSet result = null;

        try {
            connection = Connector.connectToDatabase();
            prepared = connection.prepareStatement(sql);

            result = prepared.executeQuery();

            System.out.println("--------- DADOS CADASTRADOS ---------");

            while (result.next()){
                Contact contact = new Contact(result.getString("nome"),result.getInt("idade"),result.getString("email"),result.getDate("dataCadastro"));

                System.out.println("Nome: " + contact.getNome()+ " | " + "E-mail: " + contact.getEmail()+ " | " + "Idade: " + contact.getIdade());
                System.out.println("______________________________________________________________________________________");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // UPDATE
    public static void alterarAlgumContato(String novoNome,int novaIdade, String novoEmail,int novaDataDeCadastro,int id) throws Exception {

        // Query que será inserida no banco de dados
        String sql = "update contacts set nome=?,email=?,idade=?,dataCadastro=? where id=?;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Connector.connectToDatabase();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,novoNome);
            preparedStatement.setString(2,novoEmail);
            preparedStatement.setInt(3,novaIdade);
            preparedStatement.setInt(4,novaDataDeCadastro);
            preparedStatement.setInt(5,id);

            preparedStatement.execute();

            System.out.println("Query executada com sucesso!!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void mostrarAlgumContato(int id) throws Exception {
        String sql = "select nome,email,idade,dataCadastro from heroku_0bea6e542aeaf76.contacts where id=?;";

        Connection connection = null;
        PreparedStatement prepared = null;
        ResultSet result = null;

        try {
            connection = Connector.connectToDatabase();
            prepared = connection.prepareStatement(sql);

            prepared.setInt(1,id);

            result = prepared.executeQuery();

            while (result.next()){
                Contact contact = new Contact(result.getString("nome"),result.getInt("idade"),result.getString("email"),result.getDate("dataCadastro"));

                System.out.println("______________________________ BUSCANDO PELO ID = "+id+" ______________________________");
                System.out.println("Nome: " + contact.getNome()+ " | " + "E-mail: " + contact.getEmail()+ " | " + "Idade: " + contact.getIdade());
                System.out.println("______________________________________________________________________________________");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // PLUS
    public static void enviarQueryParaBanco(String yourQuery) throws Exception {

        // Query que será inserida no banco de dados
        String sql = yourQuery;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Connector.connectToDatabase();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();

            System.out.println("Query executada com sucesso!!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // TESTES
    public static  void buscarContatoPorNome(String nome) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        String sql = "select * from contacts";

        try{
            connection = Connector.connectToDatabase();
            statement = connection.prepareStatement(sql);

            result = statement.executeQuery();

            while (result.next()){
                if (result.getString("nome").contains(nome)){
                    Contact contact = new Contact(result.getString("nome"),result.getInt("idade"),result.getString("email"),result.getDate("dataCadastro"));

                    System.out.println("Nome: " + contact.getNome()+ " | " + "E-mail: " + contact.getEmail()+ " | " + "Idade: " + contact.getIdade());
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}