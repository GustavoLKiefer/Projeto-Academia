package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Conexao {
    static Scanner scanner = new Scanner(System.in);
    static String password;
    public static Connection createConnection() {
        System.out.println("Qual a senha do seu banco de dados? Deixe vazio se não tiver.");
        System.out.println("Sua resposta: ");
        password = scanner.nextLine(); // Eu fiz isso para colocar a senha do banco de dados sem precisar alterar o código para fazer o programa funcionar.
        if (password.isEmpty()){
            password = "";
        }

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/academia?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root",
                password // Aqui você coloca sua senha do MySQL caso tiver alguma. Deixe vazio para nenhuma
            );
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Código de erro SQL: " + ex.getErrorCode());
            if (ex.getErrorCode() == 1045) {
                System.err.println("Erro: Senha do banco de dados incorreta!");
            } else {
                System.err.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver JDBC não encontrado.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
