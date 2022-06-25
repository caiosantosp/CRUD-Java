package br.com.connection.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private static final String USER = "b575c075f0eaa9";
    private static final String PASS = "d413688e";
    private static final String DATABASE_STRING = "jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_0bea6e542aeaf76";

    public static Connection connectToDatabase() throws Exception {
        // Faz conexão com o driver do jdbc
        Class.forName("com.mysql.jdbc.Driver");

        // Usa os dados do banco,senha e user para se conectar ao banco e retorna a conexão
        Connection connection = DriverManager.getConnection(DATABASE_STRING,USER,PASS);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connect = connectToDatabase();

        if(connect!=null){
            System.out.println("Conexão efetuada");
            connect.close();
        }
    }
}
