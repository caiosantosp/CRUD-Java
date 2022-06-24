package br.com.connection.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static final String USER = "DEFINA";
    private static final String PASS = "DEFINA";
    private static final String DATABASE_STRING = "jdbc:mysql://HOST:PORTA/BANCO";

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
