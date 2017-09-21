/*
 *  Classe responsavel pela conexão com o banco de dados Oracle
 */
package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author soonicz
 */
public class Conexao {

    private static Connection connection;
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    //Inserir url, porta e SID do banco que deseja conectar
    private static final String URL = "jdbc:oracle:thin:@url:port:SID";

    //Inserir usuário e senha
    private static final String USUARIO = "";
    private static final String SENHA = "";

    private Conexao() {
    }

    /*
        Metodo onde é realizado a conexão
        Não permite mais de uma conexão simultanea (synchronized)
     */
    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conexão\n" + e);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o banco de dados\n" + e);
            }
        }
        return connection;
    }
}
