package br.com.conexao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rhuan
 */
public class Mysql {

    public Statement statement;
    public ResultSet resultset;
    public Connection con;

    public static boolean connect = false;

    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/ecommerce";
            String username = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, username, password);

            connect = (connection != null);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        }

        return connection;
    }

    public static boolean conectado() {
        return connect;
    }

    public static boolean FecharConexao() {
        try {
            Mysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return Mysql.getConexaoMySQL();
    }

    public void executeSQL(String sql) {
        try {
            statement = con.createStatement(resultset.TYPE_SCROLL_SENSITIVE, resultset.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
