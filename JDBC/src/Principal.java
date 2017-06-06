
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author RA21504533
 */
public class Principal {
    public static void main(String[] args) {
        try {
    Class.forName("org.hsqldb.jdbcDriver");
    }
    catch (Exception e)
        {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
        e.printStackTrace();
        return;
    }
        System.out.println("Tudo Certo!");
     
        try {
            Connection c = DriverManager.getConnection
                ("jdbc:hsqldb:hsql://localhost", "sa", "");
            Statement comandoSQL = c.createStatement();
            
            ResultSet linhasAfetadas = comandoSQL.executeQuery("SELECT * FROM ALUNOS");
            while (linhasAfetadas.next()){
                String nome;
                String telefone;
                nome = linhasAfetadas.getString("nome");
                telefone = linhasAfetadas.getString("telefone");
                System.out.println("Nome "+nome+" telefone "+telefone );
            }
            comandoSQL.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não consegui conectar");
        }
         System.out.println("Continua Tudo Certo!");
    }
    
        
        

}
